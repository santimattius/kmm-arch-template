package com.santimattius.template.data.repositories

import com.santimattius.template.data.datasources.LocalDataSource
import com.santimattius.template.data.datasources.RemoteDataSource
import com.santimattius.template.domain.entities.Picture
import com.santimattius.template.domain.repositories.PicturesRepository

internal class PicSumRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : PicturesRepository {

    override suspend fun getPictures(): List<Picture> {
        val cachedPictures = localDataSource.getPictures()
        return cachedPictures.ifEmpty {
            val pictures = remoteDataSource.getPictures()
            localDataSource.insertPictures(pictures)
            pictures
        }
    }

}