package com.danielecampogiani.instatools.getdirectlink

import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCase
import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class GetDirectLinkModule {

    @Binds
    internal abstract fun bindUseCase(usecase: GetDirectLinkUseCaseImpl): GetDirectLinkUseCase
}