package am.leon.theme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LeonPreview(
    config: LeonThemeConfig,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) = LeonTheme(config = config) {
    Surface(
        modifier = modifier,
        content = content,
        color = LeonTheme.colors.backgroundColors.background,
    )
}