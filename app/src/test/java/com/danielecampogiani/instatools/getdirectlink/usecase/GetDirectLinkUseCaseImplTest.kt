package com.danielecampogiani.instatools.getdirectlink.usecase

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.fail
import okhttp3.OkHttpClient
import org.junit.Test

class GetDirectLinkUseCaseImplTest {

    val sut = GetDirectLinkUseCaseImpl(OkHttpClient())

    @Test
    fun runHappyPath() {

        val result = sut.run("https://www.instagram.com/p/BirZV08AmjO/")
        val either = result.blockingGet()

        either.fold({
            fail()
        }, {
            val singlePhoto = it as GetDirectLinkUseCase.Result.SinglePhoto
            assertFalse(singlePhoto.url.isBlank())
        })
    }
}