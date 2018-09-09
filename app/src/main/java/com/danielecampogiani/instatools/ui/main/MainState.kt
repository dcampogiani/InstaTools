package com.danielecampogiani.instatools.ui.main

sealed class MainState {
    object Loading : MainState()
    object Idle : MainState()
    data class ShowLinkFromClip(val link: String) : MainState()
    sealed class Error : MainState() {
        object InvalidInput : Error()
        object NoNetwork : Error()
        object LinkNotFound : Error()
        data class Unknown(val message: String?) : Error()
    }
}