package com.danielecampogiani.instatools.ui.postdetail

import android.arch.lifecycle.ViewModel
import com.danielecampogiani.instatools.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class PostDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: PostDetailViewModel): ViewModel
}