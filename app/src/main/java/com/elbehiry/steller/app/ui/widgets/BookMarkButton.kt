package com.elbehiry.steller.app.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elbehiry.steller.app.R

@Composable
fun BookMarkButton(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onBookMark: () -> Unit
) {
    var select by remember { mutableStateOf(selected) }

    val icon = if (select) Icons.Outlined.Bookmark else Icons.Filled.BookmarkBorder
    Surface(
        color = colorResource(id = R.color.black_alpha),
        shape = CircleShape,
        modifier = modifier.requiredSize(36.dp, 36.dp).clickable {
            select = !select
            onBookMark()
        }
    ) {
        Icon(
            imageVector = icon,
            tint = colorResource(id = android.R.color.white),
            contentDescription = null,
            modifier = Modifier
                .padding(6.dp)
        )
    }
}

@Composable
@Preview
fun previewBookMarkButtonClicked() {
    BookMarkButton(selected = false) {}
}

@Composable
@Preview
fun previewBookMarkButtonUnClicked() {
    BookMarkButton(selected = true) {}
}
