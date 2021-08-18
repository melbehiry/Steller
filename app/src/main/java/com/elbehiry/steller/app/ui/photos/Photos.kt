package com.elbehiry.steller.app.ui.photos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.elbehiry.steller.app.ui.main.MainViewModel
import com.elbehiry.steller.app.ui.widgets.LoadingContent
import com.elbehiry.steller.shared.model.Photo
import org.koin.androidx.compose.getViewModel


@ExperimentalFoundationApi
@Composable
fun Photos(
    onDetails: (String) -> Unit
) {
    val viewModel = getViewModel<MainViewModel>()

    val photos by viewModel.photoList.collectAsState()
    val isLoading: Boolean by viewModel.isLoading.collectAsState()
    LoadingContent(loading = isLoading) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding= PaddingValues(8.dp),
            modifier = Modifier.padding(bottom = 64.dp)
        ) {
            items(photos) { photo ->
                PhotoItem(photo) {
                    onDetails(it)
                }
            }
        }
    }
}

@Composable
fun PhotoItem(
    photo: Photo,
    modifier: Modifier = Modifier,
    onDetails: (String) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onDetails(photo.id) },
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(photo.urls?.thumb ?: ""),
            contentDescription = null,
            contentScale= ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}