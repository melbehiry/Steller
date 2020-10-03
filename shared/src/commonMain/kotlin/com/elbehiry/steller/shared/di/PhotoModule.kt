package com.elbehiry.steller.shared.di

import com.elbehiry.steller.shared.data.photo.DefaultPhotoRepository
import com.elbehiry.steller.shared.data.photo.PhotoDataSource
import com.elbehiry.steller.shared.data.photo.PhotoRemoteDataSource
import com.elbehiry.steller.shared.data.photo.PhotoRepository
import com.elbehiry.steller.shared.domain.photos.GetPhotosUseCase
import com.elbehiry.steller.shared.remote.PhotosService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val photoModule = module {
    single { PhotosService(get()) }
    single<PhotoDataSource> { PhotoRemoteDataSource(get()) }
    single<PhotoRepository> { DefaultPhotoRepository(get()) }
    single { GetPhotosUseCase(get(), get(named(DefaultDispatcher))) }
}
