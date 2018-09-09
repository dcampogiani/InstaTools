package com.danielecampogiani.instatools.shared

import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Test

class InputValidatorKtTest {

    @Test
    fun validInput() {
        val result = validate("https://www.instagram.com/p/BirZV08AmjO/")

        result.fold({
            fail()
        }, {
            assertEquals("https://www.instagram.com/p/BirZV08AmjO/", it)
        })
    }

    @Test
    fun invalidInput() {
        val result = validate("http://danielecampogiani.com/")

        result.fold({
            assertEquals(GetDirectLinkUseCase.Error.InvalidInput, it)
        }, {
            fail()
        })
    }
}