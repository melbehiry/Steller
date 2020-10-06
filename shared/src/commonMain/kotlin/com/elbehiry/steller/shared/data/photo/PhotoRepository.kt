package com.elbehiry.steller.shared.data.photo

import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    suspend fun getPhotos(page: Int?, perPage: Int?, orderBy: String?): Flow<Result<List<Photo>>>
}