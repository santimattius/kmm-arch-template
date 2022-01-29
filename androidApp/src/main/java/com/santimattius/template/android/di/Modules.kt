package com.santimattius.template.android.di

import com.santimattius.template.PicturesSDK
import com.santimattius.template.android.domain.GetPictures
import com.santimattius.template.android.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * ui layer definition module
 */
private val presentationModule = module {
    viewModel { HomeViewModel(getPictures = get<GetPictures>()) }
}


/**
 * domain layer definition module
 */
private val domainModule = module {
    factory { GetPictures(sdk = get<PicturesSDK>()) }
    factory { PicturesSDK() }
}


internal val modules = listOf(presentationModule, domainModule)
