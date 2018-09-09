package com.danielecampogiani.instatools.download.usecase

import arrow.core.Either
import javax.inject.Inject

class DownloadUseCaseImpl @Inject constructor(private val downloader: Downloader) : DownloadUseCase {

    override fun downloadPost(url: String): Either<SecurityException, Unit> {
        val filename = chooseFileName(url)
        val directory = getAndEventuallyCreateDirectory()
        return downloader.download(filename, directory, url)
    }
}