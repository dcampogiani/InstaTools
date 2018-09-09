package com.danielecampogiani.instatools.download.usecase

import android.os.Environment
import java.io.File

private const val DIR_NAME = "Insta Tools"

fun getAndEventuallyCreateDirectory(): String {
    val direct =
        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath + "/" + DIR_NAME + "/")
    if (!direct.exists()) {
        direct.mkdir()
    }
    return DIR_NAME
}