package com.elbehiry.steller.app.ui.main

import androidx.lifecycle.*
import com.elbehiry.steller.app.base.LiveCoroutinesViewModel
import com.elbehiry.steller.shared.domain.photos.GetPhotosUseCase
import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result
import com.elbehiry.steller.shared.result.data

class MainViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : LiveCoroutinesViewModel() {

    private val photoParam = MutableLiveData<GetPhotosUseCase.Params>()

    private val resultPhotos: LiveData<Result<List<Photo>>> = photoParam.switchMap { params ->
        launchOnViewModelScope {
            getPhotosUseCase(params).asLiveData()
        }
    }

    val photoList : LiveData<List<Photo>> = resultPhotos.map {
        it.data ?: listOf()
    }

    val isLoading : LiveData<Boolean> = resultPhotos.map {
        it == Result.Loading
    }


    fun getImages() {
        photoParam.value = createPhotosParam()
    }

    private fun createPhotosParam(): GetPhotosUseCase.Params {
        return GetPhotosUseCase.Params.create(1, 50, "LATEST")
    }
}