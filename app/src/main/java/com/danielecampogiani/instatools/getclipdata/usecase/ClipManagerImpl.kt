package com.danielecampogiani.instatools.getclipdata.usecase

import android.content.ClipboardManager
import javax.inject.Inject

class ClipManagerImpl @Inject constructor(private val clipboardManager: ClipboardManager) : ClipManager {
    override val currentValue: CharSequence?
        get() = readCurrentValue()

    private fun readCurrentValue(): CharSequence? {
        val item = clipboardManager.primaryClip?.getItemAt(0)
        return item?.text
    }
}