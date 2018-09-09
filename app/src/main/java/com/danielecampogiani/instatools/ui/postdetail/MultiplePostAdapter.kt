package com.danielecampogiani.instatools.ui.postdetail

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MultiplePostAdapter(
    private val data: List<String>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int) = PostDetailFragment(data[position])

    override fun getCount() = data.size
}