package com.santimattius.template.cache

import com.santimattius.kmm.shared.cache.AppDatabase
import com.santimattius.template.data.models.PictureEntity
import com.santimattius.template.data.models.PictureEntity as Picture

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clear() {
        dbQuery.transaction {
            dbQuery.removeAllPictures()
        }
    }

    internal fun getAllPictures(): List<Picture> {
        return dbQuery.selectAllPictures { id, author, width, height, url, downloadUrl ->
            PictureEntity(
                id = id,
                author = author,
                width = width.toInt(),
                height = height.toInt(),
                url = url,
                downloadUrl = downloadUrl
            )
        }.executeAsList()
    }

    internal fun insertPictures(pictures: List<Picture>) {
        dbQuery.transaction {
            pictures.forEach { picture ->
                dbQuery.selectPictureById(picture.id)
                    .executeAsOneOrNull()?.let {
                    insertPicture(picture)
                }
            }
        }
    }

    private fun insertPicture(picture: Picture) {
        dbQuery.insertPicture(
            id = picture.id,
            author = picture.author,
            width = picture.width.toLong(),
            height = picture.height.toLong(),
            url = picture.url,
            downloadUrl = picture.downloadUrl
        )
    }
}