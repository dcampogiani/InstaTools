package com.danielecampogiani.instatools.download.usecase

import arrow.core.Either

interface DownloadUseCase {

    fun downloadPost(url: String): Either<SecurityException, Unit>
}