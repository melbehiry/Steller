package com.elbehiry.steller.app.ui.photos

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elbehiry.steller.app.ui.custom.StaggeredVerticalGrid
import com.elbehiry.steller.app.ui.theme.purple500
import com.elbehiry.steller.app.ui.util.NetworkImage
import com.elbehiry.steller.app.ui.util.statusBarsPadding
import com.elbehiry.steller.shared.model.Photo

@Composable
fun HomePhotos(
    photos: List<Photo>,
    selectPhoto: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    ScrollableColumn(
        modifier = modifier.statusBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier.padding(4.dp)
        ) {
            photos.forEach { photo ->
                HomePhoto(photo = photo, selectPhoto = selectPhoto)
            }
        }
    }
}

@Composable
fun HomePhoto(
    photo: Photo,
    selectPhoto: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(1.dp),
        color = MaterialTheme.colors.background,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.clickable(
                onClick = { selectPhoto(photo.id) },
                indication = RippleIndication(color = purple500)
            )
        ) {
            val (image) = createRefs()
            NetworkImage(
                url = photo.urls?.thumb ?: "",
                modifier = Modifier.aspectRatio(4f / 3f)
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    }
            )
        }
    }
}
