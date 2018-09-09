package com.danielecampogiani.instatools.getclipdata.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test

class GetClipDataUseCaseImplTest {

    val clipManager = mock<ClipManager>()

    val sut = GetClipDataUseCaseImpl(clipManager)

    @Test
    fun noData() {
        whenever(clipManager.currentValue).thenReturn(null)

        val result = sut.run()

        assertNull(result)
    }

    @Test
    fun invalidData() {
        whenever(clipManager.currentValue).thenReturn("http://danielecampogiani.com/")

        val result = sut.run()

        assertNull(result)
    }

    @Test
    fun validData() {
        whenever(clipManager.currentValue).thenReturn("https://www.instagram.com/p/BkQe6-sgBbu/")

        val result = sut.run()

        assertEquals("https://www.instagram.com/p/BkQe6-sgBbu/", result)
    }
}