package com.danielecampogiani.instatools.ui.postdetail

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.danielecampogiani.instatools.InstaToolsApplication
import com.danielecampogiani.instatools.R
import com.danielecampogiani.instatools.ui.customlayout.ColorUtils
import com.danielecampogiani.instatools.ui.customlayout.ElasticDragDismissFrameLayout
import extensions.doOnPreDraw
import kotlinx.android.synthetic.main.fragment_post_detail.*
import javax.inject.Inject

private const val PERMISSION_REQUEST = 772

class PostDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: PostDetailViewModel

    private val imageUrl: String by lazy { arguments!!.getString(IMAGE_URL) }

    private lateinit var dragListener: ElasticDragDismissFrameLayout.ElasticDragDismissCallback

    companion object {

        private const val IMAGE_URL = "IMAGE_URL"

        operator fun invoke(imageUrl: String) = newInstance(imageUrl)

        private fun newInstance(imageUrl: String): PostDetailFragment {
            val fragment = PostDetailFragment()
            val args = Bundle(1)
            args.putString(IMAGE_URL, imageUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        InstaToolsApplication.getAppComponent(context).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        downloadImage(imageUrl)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[PostDetailViewModel::class.java]

        download_button.setOnClickListener {
            doWithPermission { viewModel.download(imageUrl) }
        }

        viewModel.liveData.observe(this, Observer {
            it?.getContentIfNotHandled()?.let {
                when (it) {
                    PostDetailState.DownloadStarted -> notifyDownloadStarted()
                    PostDetailState.PermissionError -> notifyDownloadError()
                }
            }
        })

        dragListener = createDragListener()
    }

    private fun createDragListener(): ElasticDragDismissFrameLayout.ElasticDragDismissCallback {
        val activity = requireActivity()
        val backgroundColor = ContextCompat.getColor(activity, R.color.primary_dark)

        return object : ElasticDragDismissFrameLayout.ElasticDragDismissCallback() {

            override fun onDrag(
                elasticOffset: Float,
                elasticOffsetPixels: Float,
                rawOffset: Float,
                rawOffsetPixels: Float
            ) {
                val alphaColor = ColorUtils.modifyAlpha(backgroundColor, 1 - rawOffset)
                scrollView.setBackgroundColor(alphaColor)
            }

            override fun onDragDismissed() {
                activity.onBackPressed()
            }
        }
    }

    private fun downloadImage(imageUrl: String) {
        image.doOnPreDraw {
            val lp = it.layoutParams
            val height = scrollView.height
            lp.height = height
            it.layoutParams = lp

            Glide.with(this)
                .load(imageUrl)
                .into(image)
        }
    }

    private fun doWithPermission(actionRequiringPermission: () -> Unit) {

        activity?.let {
            if (ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST)
            } else {
                actionRequiringPermission()
            }
        }
    }

    private fun notifyDownloadStarted() {
        Toast.makeText(context, getString(R.string.notify_download_started), Toast.LENGTH_SHORT).show()
    }

    private fun notifyDownloadError() {
        val snackbar = Snackbar.make(content, R.string.notify_download_needs_permission, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction(R.string.settings) {

            activity?.let {
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri = Uri.fromParts("package", it.packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        }
        snackbar.show()
    }

    override fun onResume() {
        super.onResume()
        dragListener.let {
            root.addListener(it)
        }
    }

    override fun onPause() {
        dragListener.let {
            root.removeListener(it)
        }
        super.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                viewModel.download(imageUrl)
            } else {
                notifyDownloadError()
            }
        }
    }
}
