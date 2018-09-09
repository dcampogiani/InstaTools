package com.danielecampogiani.instatools.getclipdata.usecase

import com.danielecampogiani.instatools.shared.validate
import javax.inject.Inject

class GetClipDataUseCaseImpl @Inject constructor(
        private val clipManager: ClipManager
) : GetClipDataUseCase {


    override fun run(): String? {
        val currentValue = clipManager.currentValue?.toString()

        return if (currentValue == null) {
            null
        } else {
            val validLink = validate(currentValue)
            return validLink.fold({
                null
            }, {
                currentValue
            })
        }
    }
}