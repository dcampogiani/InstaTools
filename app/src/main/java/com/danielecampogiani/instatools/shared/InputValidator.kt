package com.danielecampogiani.instatools.shared

import arrow.core.Either
import com.danielecampogiani.instatools.getdirectlink.usecase.GetDirectLinkUseCase

private const val URL_START = "https://www.instagram.com/"

fun validate(inputUrl: String): Either<GetDirectLinkUseCase.Error, String> {

    return if (inputUrl.startsWith(URL_START)) {
        Either.right(inputUrl)
    } else {
        Either.left(GetDirectLinkUseCase.Error.InvalidInput)
    }
}