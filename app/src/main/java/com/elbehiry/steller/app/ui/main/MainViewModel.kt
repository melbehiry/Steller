package com.elbehiry.steller.app.ui.main

import androidx.lifecycle.*
import com.elbehiry.steller.app.ui.util.WhileViewSubscribed
import com.elbehiry.steller.shared.domain.photos.GetPhotosUseCase
import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result
import com.elbehiry.steller.shared.result.data
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _errorMessage = Channel<String>(1, BufferOverflow.DROP_LATEST)
    val errorMessage: Flow<String> =
        _errorMessage.receiveAsFlow().shareIn(viewModelScope, WhileViewSubscribed)
    private val getPhotos = MutableSharedFlow<GetPhotosUseCase.Params>()

    private val _photoList = MutableStateFlow<List<Photo>>(emptyList())
    val photoList: StateFlow<List<Photo>> = _photoList

    private val viewState: StateFlow<Result<List<Photo>?>> =
        getPhotos.flatMapLatest {
            getPhotosUseCase(it)
        }.onEach {
            if (it is Result.Error) {
                _errorMessage.trySend(it.exception.message ?: "Error")
            }
        }.stateIn(viewModelScope, WhileViewSubscribed, Result.Loading)

    val isLoading: StateFlow<Boolean> = viewState
        .mapLatest {
            it == Result.Loading
        }.stateIn(viewModelScope, WhileViewSubscribed, false)


    init {
        viewModelScope.launch {
            viewState
                .filter { it is Result.Success && !it.data.isNullOrEmpty() }
                .mapLatest {
                    it.data
                }.collect { venues ->
                    venues?.let {
                        _photoList.value = venues
                    }
                }
        }

        viewModelScope.launch {
            getPhotos.emit(createPhotosParam())
        }
    }

    private fun createPhotosParam(): GetPhotosUseCase.Params {
        return GetPhotosUseCase.Params.create(1, 50, "LATEST")
    }
}