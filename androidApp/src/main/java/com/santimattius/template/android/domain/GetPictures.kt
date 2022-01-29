package com.santimattius.template.android.domain

import com.santimattius.template.PicturesSDK


class GetPictures(private val sdk: PicturesSDK) {

    suspend operator fun invoke() = sdk.getPictures()
}