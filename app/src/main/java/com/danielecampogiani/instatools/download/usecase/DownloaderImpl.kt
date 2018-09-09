package com.danielecampogiani.instatools.download.usecase

import android.app.DownloadManager
import android.net.Uri
import android.os.Environment
import arrow.core.Either
import java.io.File
import javax.inject.Inject

class DownloaderImpl @Inject constructor(private val downloadManager: DownloadManager) : Downloader {

    override fun download(fileName: String, directory: String, url: String): Either<SecurityException, Unit> {

        return try {
            val downloadUri = Uri.parse(url)
            val request = DownloadManager.Request(downloadUri)
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(fileName)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + directory + File.separator + fileName)
            request.allowScanningByMediaScanner()
            downloadManager.enqueue(request)
            return Either.right(Unit)
        } catch (e: SecurityException) {
            Either.left(e)
        }
    }
}