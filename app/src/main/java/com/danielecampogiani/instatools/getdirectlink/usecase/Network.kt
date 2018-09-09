package com.danielecampogiani.instatools.getdirectlink.usecase

import arrow.core.Either
import okhttp3.OkHttpClient
import okhttp3.Request

fun getHtml(okHttpClient: OkHttpClient, url: String): Either<GetDirectLinkUseCase.Error, String> {

    return try {
        val request = Request.Builder()
            .url(url)
            .build()

        val response = okHttpClient.newCall(request).execute()
        Either.right(response.body()!!.string())
    } catch (e: Exception) {
        Either.left(GetDirectLinkUseCase.Error.NoNetwork)
    }
}