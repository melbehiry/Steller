package com.elbehiry.steller.app.ui.photos

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.contentColor
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elbehiry.steller.app.R
import com.elbehiry.steller.app.ui.ext.visible
import com.elbehiry.steller.app.ui.main.MainViewModel
import com.elbehiry.steller.app.ui.theme.purple200
import com.elbehiry.steller.app.ui.theme.yellowDarkPrimary
import com.elbehiry.steller.app.ui.util.navigationBarsHeightPlus
import com.elbehiry.steller.app.ui.util.navigationBarsPadding
import com.elbehiry.steller.shared.model.Photo
import com.elbehiry.steller.shared.result.Result


@Composable
fun Photos(
    viewModel: MainViewModel,
    selectPhoto: (String) -> Unit,
    selectedTab: StellerHomeTab,
    setSelectedTab: (StellerHomeTab) -> Unit
) {
    val photos: List<Photo> by viewModel.photoList.observeAsState(listOf())
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val tabs = StellerHomeTab.values()

    ConstraintLayout {
        val (body, progress) = createRefs()
        Scaffold(
            backgroundColor = MaterialTheme.colors.primarySurface,
            topBar = { StellerTopBar() },
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            },
            bottomBar = {
                BottomNavigation {
                    tabs.forEach { tab ->
                        BottomNavigationItem(
                            icon = { Icon(asset = vectorResource(tab.icon)) },
                            label = { Text(text = stringResource(tab.title), color = Color.White) },
                            selected = tab == selectedTab,
                            onClick = { setSelectedTab(tab) },
                            alwaysShowLabels = false,
                            selectedContentColor = contentColor(),
                            unselectedContentColor = contentColor(),
                            modifier = Modifier.navigationBarsPadding()
                        )
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            when (selectedTab) {
                StellerHomeTab.HOME -> HomePhotos(photos, selectPhoto, modifier)
                else -> HomePhotos(photos, selectPhoto, modifier)
            }
        }
        CircularProgressIndicator(
            modifier = Modifier.constrainAs(progress) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.visible(isLoading)
        )
    }
}

@Composable
fun StellerTopBar() {
    TopAppBar(
        elevation = 6.dp,
        modifier = Modifier.preferredHeight(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

enum class StellerHomeTab(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    HOME(R.string.home_tab, R.drawable.ic_grain),
    SEARCH(R.string.search_tab, R.drawable.ic_featured)
}