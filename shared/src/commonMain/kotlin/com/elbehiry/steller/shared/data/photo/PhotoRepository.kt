package com.elbehiry.steller.shared.data.photo

import com.elbehiry.steller.shared.model.Photo

interface PhotoRepository {

    suspend fun getPhotos(page: Int?, perPage: Int?, orderBy: String?): List<Photo>
}