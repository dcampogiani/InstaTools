package com.danielecampogiani.instatools.inject

import com.danielecampogiani.instatools.download.DownloadModule
import com.danielecampogiani.instatools.getclipdata.GetClipDataModule
import com.danielecampogiani.instatools.getdirectlink.GetDirectLinkModule
import com.danielecampogiani.instatools.ui.main.MainFragment
import com.danielecampogiani.instatools.ui.main.MainModule
import com.danielecampogiani.instatools.ui.postdetail.PostDetailFragment
import com.danielecampogiani.instatools.ui.postdetail.PostDetailModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidModule::class,
    ViewModelBuilder::class,
    NetworkModule::class,
    MainModule::class,
    PostDetailModule::class,
    GetClipDataModule::class,
    GetDirectLinkModule::class,
    DownloadModule::class
])
interface AppComponent {

    fun inject(mainFragment: MainFragment)

    fun inject(postDetailFragment: PostDetailFragment)
}