package com.danielecampogiani.instatools.getdirectlink.usecase

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.fail
import okhttp3.OkHttpClient
import org.junit.Test

class NetworkKtTest {

    private val okHttpClient = OkHttpClient()

    @Test
    fun getHtml() {

        val html = com.danielecampogiani.instatools.getdirectlink.usecase.getHtml(okHttpClient, "https://www.instagram.com/p/BirZV08AmjO/")

        html.fold({
            fail()
        }, {
            assertNotNull(it)
        })
    }
}