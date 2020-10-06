package com.elbehiry.steller.shared.remote

import com.elbehiry.steller.shared.model.Photo
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*



class PhotosService(private val client: HttpClient) {

    suspend fun getPhotos(
        page: Int?,
        perPage: Int?,
        orderBy: String?
    ) = client.request<List<Photo>>(PHOTOS_URL) {
        method = HttpMethod.Get

        parameter("page", page)
        parameter("per_page", perPage)
        parameter("order_by", orderBy)
    }
}