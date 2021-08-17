package com.elbehiry.steller.app.ui.main

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elbehiry.steller.app.R
import com.elbehiry.steller.app.ui.photos.Photos
import com.elbehiry.steller.app.ui.search.Search
import com.google.accompanist.insets.navigationBarsPadding


@ExperimentalFoundationApi
@Composable
fun MainContent(
    onDetails: (Int) -> Unit
) {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(StellerHomeTab.HOME) }
    val tabs = StellerHomeTab.values()
    Scaffold(
        backgroundColor = MaterialTheme.colors.primarySurface,
        topBar = { HomeTopBar() },
        bottomBar = {
            BottomNavigation {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = stringResource(id = tab.title)) },
                        selected = tab == selectedTab,
                        onClick = { setSelectedTab(tab) },
                        alwaysShowLabel = false,
                        selectedContentColor = MaterialTheme.colors.secondary,
                        unselectedContentColor = LocalContentColor.current,
                        modifier = Modifier.navigationBarsPadding()
                    )
                }
            }
        }
    ) {
        when (selectedTab) {
            StellerHomeTab.HOME -> Photos {

            }
            StellerHomeTab.SEARCH -> Search()
        }
    }
}


@Composable
fun HomeTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(8.dp)
            )
        },
        elevation = 6.dp
    )
}

enum class StellerHomeTab(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    HOME(R.string.home_tab, Icons.Filled.BlurOn),
    SEARCH(R.string.search_tab, Icons.Filled.Search)
}