package com.danielecampogiani.instatools.getdirectlink.usecase

import arrow.core.Either
import io.reactivex.Single

interface GetDirectLinkUseCase {

    fun run(shareUrl: String): Single<Either<Error, Result>>

    sealed class Error {
        object InvalidInput : Error()
        object NoNetwork : Error()
        object LinkNotFound : Error()
    }

    sealed class Result {
        data class SinglePhoto(val url: String) : Result()
        data class MultiplePhotos(val urls: List<String>) : Result()
    }
}