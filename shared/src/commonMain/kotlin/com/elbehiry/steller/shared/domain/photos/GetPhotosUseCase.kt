package com.elbehiry.steller.shared.domain.photos

import com.elbehiry.steller.shared.data.photo.PhotoRepository
import com.elbehiry.steller.shared.domain.FlowUseCase
import com.elbehiry.steller.shared.domain.UseCase
import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlin.jvm.JvmStatic

open class GetPhotosUseCase(
    private val photoRepository: PhotoRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<GetPhotosUseCase.Params, List<Photo>>(coroutineDispatcher) {

    override suspend fun execute(parameters: Params): Flow<Result<List<Photo>>> {
        return photoRepository.getPhotos(parameters.page, parameters.perPage, parameters.orderBy)
    }


    class Params private constructor(val page: Int?, val perPage: Int?, val orderBy: String?) {
        companion object {
            @JvmStatic
            fun create(page: Int?, perPage: Int?, orderBy: String?): Params {
                return Params(page, perPage, orderBy)
            }
        }
    }
}