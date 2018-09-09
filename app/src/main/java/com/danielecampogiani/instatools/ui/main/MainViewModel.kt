package com.danielecampogiani.instatools.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.danielecampogiani.instatools.getclipdata.usecase.GetClipDataUseCase
import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCase
import com.danielecampogiani.instatools.ui.navigation.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: GetDirectLinkUseCase,
    private val getClipDataUseCase: GetClipDataUseCase
    ) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val mutableState: MutableLiveData<MainState> = MutableLiveData()
    val state: LiveData<MainState>
        get() = mutableState

    private val mutableNavigation = MutableLiveData<Event<GetDirectLinkUseCase.Result>>()
    val navigation: LiveData<Event<GetDirectLinkUseCase.Result>>
        get() = mutableNavigation

    fun get(sharingUrl: String?) {

        if (sharingUrl.isNullOrBlank()) {
            mutableState.value = MainState.Error.InvalidInput
            return
        }
        mutableState.value = MainState.Loading

        val disposable = useCase.run(sharingUrl!!)
            .subscribeOn(Schedulers.io())
            .subscribe({
                val mainState = it.fold({
                    when (it) {
                        GetDirectLinkUseCase.Error.InvalidInput -> MainState.Error.InvalidInput
                        GetDirectLinkUseCase.Error.NoNetwork -> MainState.Error.NoNetwork
                        GetDirectLinkUseCase.Error.LinkNotFound -> MainState.Error.LinkNotFound
                    }
                }, {
                    mutableNavigation.postValue(Event(it))
                    MainState.Idle
                })
                mutableState.postValue(mainState)

            }, {
                mutableState.postValue(MainState.Error.Unknown(it.message))
            })

        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    fun checkClip() {
        val dataFromClip = getClipDataUseCase.run()

        dataFromClip?.let {
            mutableState.value = MainState.ShowLinkFromClip(it)
        }
    }
}