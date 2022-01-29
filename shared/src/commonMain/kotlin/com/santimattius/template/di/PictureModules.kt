package com.santimattius.template.di

import com.santimattius.template.cache.Database
import com.santimattius.template.cache.DatabaseDriverFactory
import com.santimattius.template.core.ktorHttpClient
import com.santimattius.template.data.datasources.LocalDataSource
import com.santimattius.template.data.datasources.RemoteDataSource
import com.santimattius.template.data.datasources.implementation.RoomDataSource
import com.santimattius.template.data.datasources.implementation.ServiceDataSource
import com.santimattius.template.data.datasources.implementation.client.PicSumClient
import com.santimattius.template.data.repositories.PicSumRepository
import com.santimattius.template.domain.repositories.PicturesRepository
import com.santimattius.template.domain.usecases.GetPictures
import io.ktor.client.*
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initModule(
    databaseDriverFactory: DatabaseDriverFactory,
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    loadKoinModules(modules = commonModule + module {
        factory { Database(databaseDriverFactory) }
    })
}

// called by iOS etc
fun initModule(databaseDriverFactory: DatabaseDriverFactory) = initModule(databaseDriverFactory) {
}

val commonModule = module {
    //use cases
    factory { GetPictures(repository = get()) }
    //repository
    factory<PicturesRepository> {
        PicSumRepository(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }
    //data source
    factory<LocalDataSource> {
        RoomDataSource(
            database = get(),
            dispatcher = Dispatchers.Default
        )
    }
    factory<RemoteDataSource> {
        ServiceDataSource(
            client = get<PicSumClient>()
        )
    }
    //client
    single<PicSumClient> {
        PicSumClient(
            baseUrl = "https://pictures.getsandbox.com:443",
            client = get<HttpClient>()
        )
    }
    single<HttpClient> { ktorHttpClient() }
}