package com.danielecampogiani.instatools.download.usecase

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FileNameChooserKtTest {

    @Test
    fun chooseFileName() {
        val fileName = chooseFileName("https://www.instagram.com/p/BirZV08AmjO/")
        assertEquals("BirZV08AmjO", fileName)
    }
}