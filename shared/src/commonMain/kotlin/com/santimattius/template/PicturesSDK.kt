package com.santimattius.template

import com.santimattius.template.domain.usecases.GetPictures
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PicturesSDK : KoinComponent {

    private val pictures: GetPictures by inject()

    suspend fun getPictures() = pictures()
}