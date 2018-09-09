package com.danielecampogiani.instatools.download

import android.app.DownloadManager
import android.content.Context
import com.danielecampogiani.instatools.download.usecase.DownloadUseCase
import com.danielecampogiani.instatools.download.usecase.DownloadUseCaseImpl
import com.danielecampogiani.instatools.download.usecase.Downloader
import com.danielecampogiani.instatools.download.usecase.DownloaderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DownloadModule {

    @Provides
    internal fun providesUseCase(usecase: DownloadUseCaseImpl): DownloadUseCase {
        return usecase
    }

    @Provides
    @Singleton
    internal fun provideDownloadManager(context: Context): DownloadManager {
        return context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    }

    @Provides
    internal fun providesDownloader(downloader: DownloaderImpl): Downloader {
        return downloader
    }
}