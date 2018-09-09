package com.danielecampogiani.instatools.getclipdata

import com.danielecampogiani.instatools.getclipdata.usecase.ClipManager
import com.danielecampogiani.instatools.getclipdata.usecase.ClipManagerImpl
import com.danielecampogiani.instatools.getclipdata.usecase.GetClipDataUseCase
import com.danielecampogiani.instatools.getclipdata.usecase.GetClipDataUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class GetClipDataModule {

    @Binds
    internal abstract fun bindClipManager(clipManager: ClipManagerImpl): ClipManager

    @Binds
    internal abstract fun bindUseCase(getClipDataUseCaseImpl: GetClipDataUseCaseImpl): GetClipDataUseCase
}