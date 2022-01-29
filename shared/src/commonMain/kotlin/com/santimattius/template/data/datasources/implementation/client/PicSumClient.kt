package com.santimattius.template.data.datasources.implementation.client

import com.santimattius.template.core.Result
import com.santimattius.template.data.models.NetworkPicture
import com.santimattius.template.data.models.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class PicSumClient(
    private val baseUrl: String,
    private val client: HttpClient,
) {

    suspend fun fetchList(): Result<List<NetworkPicture>> = try {
        val url =
            URLBuilder(urlString = "$baseUrl/data/pictures")
                .build()
        val response = client.get<Response>(url = url)
        Result.success(response.data)
    } catch (exception: Throwable) {
        Result.failure(ServiceError(exception.message.orEmpty()))
    }
}