import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.elbehiry.steller.navigation.NavHostComponent
import com.elbehiry.steller.theme.StellerTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication(
    title = "Steller",
    state = WindowState(width = 1280.dp, height = 800.dp),
    icon = BitmapPainter(useResource("ic_launcher.png", ::loadImageBitmap)),
) {
    StellerTheme {
        rememberRootComponent(factory = ::NavHostComponent).render()
    }
}
