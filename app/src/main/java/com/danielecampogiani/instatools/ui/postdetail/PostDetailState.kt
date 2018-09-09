package com.danielecampogiani.instatools.ui.postdetail

sealed class PostDetailState {
    object DownloadStarted : PostDetailState()
    object PermissionError : PostDetailState()
}