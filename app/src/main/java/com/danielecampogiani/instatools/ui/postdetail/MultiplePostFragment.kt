package com.danielecampogiani.instatools.ui.postdetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielecampogiani.instatools.R
import kotlinx.android.synthetic.main.fragment_multiple_post.*

private const val URLS = "URLS"

class MultiplePostFragment : Fragment() {

    companion object {

        operator fun invoke(urls: List<String>) = newInstance(urls)

        private fun newInstance(urls: List<String>): MultiplePostFragment {
            return MultiplePostFragment().apply {
                arguments = Bundle(1).apply {
                    putStringArrayList(URLS, ArrayList(urls))
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_multiple_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val urls = arguments!!.getStringArrayList(URLS)
        pager.adapter = MultiplePostAdapter(urls, childFragmentManager)
    }

}
