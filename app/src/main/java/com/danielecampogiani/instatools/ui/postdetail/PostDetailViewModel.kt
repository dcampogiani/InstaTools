package com.danielecampogiani.instatools.ui.postdetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.danielecampogiani.instatools.download.usecase.DownloadUseCase
import com.danielecampogiani.instatools.ui.navigation.Event
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostDetailViewModel @Inject constructor(
    private val downloadUseCase: DownloadUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val mutableLiveData: MutableLiveData<Event<PostDetailState>> = MutableLiveData()
    val liveData: LiveData<Event<PostDetailState>>
        get() = mutableLiveData

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    fun download(imageUrl: String) {
        val detailState = downloadUseCase.downloadPost(imageUrl)
            .fold({ PostDetailState.PermissionError }, { PostDetailState.DownloadStarted })
        mutableLiveData.value = Event(detailState)
    }
}