package com.elbehiry.steller.shared.domain.photos

import com.elbehiry.steller.shared.data.photo.PhotoRepository
import com.elbehiry.steller.shared.domain.UseCase
import com.elbehiry.steller.shared.model.Photo
import kotlinx.coroutines.CoroutineDispatcher
import kotlin.jvm.JvmStatic

open class GetPhotosUseCase(
    private val photoRepository: PhotoRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<GetPhotosUseCase.Params, List<Photo>>(coroutineDispatcher) {

    override suspend fun execute(parameter: Params): List<Photo> {
        return photoRepository.getPhotos(parameter.page, parameter.perPage, parameter.orderBy)
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