package com.elbehiry.steller.shared.data.photo

import com.elbehiry.steller.shared.model.Photo

class DefaultPhotoRepository(private val photoDataSource: PhotoDataSource) : PhotoRepository {

    override suspend fun getPhotos(
        page: Int?,
        perPage: Int?,
        orderBy: String?
    ): List<Photo> = photoDataSource.getPhotos(page, perPage, orderBy)
}