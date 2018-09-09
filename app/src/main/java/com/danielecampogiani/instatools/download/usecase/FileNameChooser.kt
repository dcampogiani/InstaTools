package com.danielecampogiani.instatools.download.usecase

import android.net.Uri

fun chooseFileName(url: String): String {
    val uri = Uri.parse(url)
    return uri.lastPathSegment
}