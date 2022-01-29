package com.santimattius.template.data.datasources.implementation

import com.santimattius.template.cache.Database
import com.santimattius.template.data.datasources.LocalDataSource
import com.santimattius.template.data.models.mapping.asDbEntities
import com.santimattius.template.domain.entities.Picture
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class RoomDataSource(
    private val database: Database,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) : LocalDataSource {

    override suspend fun getPictures(): List<Picture> = withContext(dispatcher) {
        database.getAllPictures()
    }

    override suspend fun insertPictures(pictures: List<Picture>) = withContext(dispatcher) {
        database.insertPictures(pictures.asDbEntities())
    }
}


