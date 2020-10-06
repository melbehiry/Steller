package com.elbehiry.steller.shared.data.photo

import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultPhotoRepository(private val photoDataSource: PhotoDataSource) : PhotoRepository {

    override suspend fun getPhotos(
        page: Int?,
        perPage: Int?,
        orderBy: String?
    ): Flow<Result<List<Photo>>> {
        return flow {
            emit(Result.Loading)
            try {
                val photos = photoDataSource.getPhotos(page, perPage, orderBy)
                emit(Result.Success(photos))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }
}