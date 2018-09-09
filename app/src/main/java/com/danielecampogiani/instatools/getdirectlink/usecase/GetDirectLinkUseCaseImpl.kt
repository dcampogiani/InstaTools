package com.danielecampogiani.instatools.getdirectlink.usecase

import arrow.core.Either
import arrow.core.fix
import arrow.core.monad
import arrow.typeclasses.binding
import com.danielecampogiani.instatools.shared.validate
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class GetDirectLinkUseCaseImpl @Inject constructor(
    private val okHttpClient: OkHttpClient
) : GetDirectLinkUseCase {

    override fun run(shareUrl: String): Single<Either<GetDirectLinkUseCase.Error, GetDirectLinkUseCase.Result>> {
        return Single.fromCallable { blockingRun(shareUrl) }
    }

    private fun blockingRun(shareUrl: String): Either<GetDirectLinkUseCase.Error, GetDirectLinkUseCase.Result> {
        return Either.monad<GetDirectLinkUseCase.Error>().binding {
            val validUrl = validate(shareUrl).bind()
            val html = getHtml(okHttpClient, validUrl).bind()
            parseDirectLinks(html).bind()
        }.fix()
    }
}