package com.danielecampogiani.instatools.inject

import android.content.ClipboardManager
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AndroidModule {

    @Provides
    fun provideClipboardManager(context: Context): ClipboardManager =
        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
}