package com.danielecampogiani.instatools.getdirectlink.usecase

import arrow.core.Either

private val regex = """."display_url":"([^"]*)""".toRegex()


fun parseDirectLinks(html: String): Either<GetDirectLinkUseCase.Error, GetDirectLinkUseCase.Result> {

    val regexResult = regex.findAll(html)
    val filtered = regexResult.map {
        val value = it.value
        value.substring(16, value.length)
    }
    val links = filtered.distinct().toList()

    return when {
        links.isEmpty() -> Either.left(GetDirectLinkUseCase.Error.LinkNotFound)
        links.size == 1 -> Either.right(GetDirectLinkUseCase.Result.SinglePhoto(links.first()))
        else -> Either.right(GetDirectLinkUseCase.Result.MultiplePhotos(links))
    }
}