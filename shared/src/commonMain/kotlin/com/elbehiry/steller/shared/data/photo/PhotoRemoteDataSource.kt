package com.elbehiry.steller.shared.data.photo

import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.remote.PhotosService

class PhotoRemoteDataSource(private val photosService: PhotosService) : PhotoDataSource {

    override suspend fun getPhotos(
        page: Int?,
        perPage: Int?,
        orderBy: String?
    ): List<Photo> = photosService.getPhotos(page, perPage, orderBy)
}