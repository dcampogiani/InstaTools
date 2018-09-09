package com.danielecampogiani.instatools.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.transition.Slide
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielecampogiani.instatools.InstaToolsApplication
import com.danielecampogiani.instatools.R
import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCase
import com.danielecampogiani.instatools.ui.about.AboutActivity
import com.danielecampogiani.instatools.ui.postdetail.MultiplePostFragment
import com.danielecampogiani.instatools.ui.postdetail.PostDetailFragment
import extensions.dismissKeyboard
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    companion object {

        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle(0)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        InstaToolsApplication.getAppComponent(context).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when (it.itemId) {
                R.id.menu_item_about -> {
                    startActivity(Intent(context, AboutActivity::class.java))
                    true
                }

                else -> {
                    false
                }
            }
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.state.observe(this, Observer {

            return@Observer when (it) {
                is MainState.ShowLinkFromClip -> renderLinkFromClip(it.link)
                MainState.Loading -> renderLoading()
                MainState.Idle -> renderIdle()
                MainState.Error.InvalidInput -> renderInvalidInput()
                MainState.Error.NoNetwork -> renderError(getString(R.string.error_no_network))
                MainState.Error.LinkNotFound -> renderError(getString(R.string.error_could_not_find_link))
                is MainState.Error.Unknown -> renderError(it.message)
                null -> {
                }
            }
        })

        viewModel.navigation.observe(this, Observer {
            it?.getContentIfNotHandled()?.let {
                goToPostDetail(it)
            }
        })

        get_button.setOnClickListener {
            dismissKeyboard()
            viewModel.get(input_text.text?.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkClip()
    }

    private fun renderLinkFromClip(link: String) {
        animate()
        loader.visibility = View.GONE
        input_text.setText(link)
        input_layout.error = null
        hideError()
        get_button.visibility = View.VISIBLE
    }

    private fun renderInvalidInput() {
        animate()
        loader.visibility = View.GONE
        input_layout.error = getString(R.string.error_invalid_input)
        hideError()
        get_button.visibility = View.VISIBLE
    }

    private fun renderLoading() {
        animate()
        loader.visibility = View.VISIBLE
        input_layout.error = null
        hideError()
        get_button.visibility = View.GONE
    }

    private fun renderIdle() {
        animate()
        loader.visibility = View.GONE
        input_layout.error = null
        hideError()
        get_button.visibility = View.VISIBLE
    }

    private fun goToPostDetail(post: GetDirectLinkUseCase.Result) {

        activity?.let {

            val destination = when (post) {
                is GetDirectLinkUseCase.Result.SinglePhoto -> PostDetailFragment(post.url)
                is GetDirectLinkUseCase.Result.MultiplePhotos -> MultiplePostFragment(post.urls)
            }.apply {
                enterTransition = Slide()
            }

            it.supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, destination)
                .addToBackStack(null).commit()
        }
    }

    private fun renderError(errorMessage: String?) {
        animate()
        loader.visibility = View.GONE
        input_layout.error = null
        error_view.visibility = View.VISIBLE
        error_view.text = errorMessage
        get_button.visibility = View.VISIBLE
    }

    private fun animate() {
        TransitionManager.beginDelayedTransition(root)
    }

    private fun hideError() {
        error_view.text = ""
        error_view.visibility = View.GONE
    }
}
