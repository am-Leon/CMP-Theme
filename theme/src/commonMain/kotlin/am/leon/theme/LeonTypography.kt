package am.leon.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

val LocalLeonTypography =
    staticCompositionLocalOf<LeonTypography> { error("No LeonTypography provided") }

@Immutable
data class LeonTypography(
    val display: SizedTextStyle = SizedTextStyle(),
    val headline: SizedTextStyle = SizedTextStyle(),
    val title: SizedTextStyle = SizedTextStyle(),
    val label: SizedTextStyle = SizedTextStyle(),
    val body: SizedTextStyle = SizedTextStyle(),
)

@Immutable
data class SizedTextStyle(
    val large: TextStyle = TextStyle.Default,
    val medium: TextStyle = TextStyle.Default,
    val small: TextStyle = TextStyle.Default,
    val extraSmall: TextStyle = TextStyle.Default,
)

internal expect val platformTextStyle: PlatformTextStyle?

@Composable
internal fun rememberLeonTypography(
    typeScale: TypeScale,
    fontFamily: FontFamily,
): LeonTypography {
    return LeonTypography(
        display = SizedTextStyle(
            large = typeScale.displayLarge.toTextStyle(fontFamily),
            medium = typeScale.displayMedium.toTextStyle(fontFamily),
            small = typeScale.displaySmall.toTextStyle(fontFamily),
        ),
        headline = SizedTextStyle(
            large = typeScale.headlineLarge.toTextStyle(fontFamily),
            medium = typeScale.headlineMedium.toTextStyle(fontFamily),
            small = typeScale.headlineSmall.toTextStyle(fontFamily),
        ),
        title = SizedTextStyle(
            large = typeScale.titleLarge.toTextStyle(fontFamily),
            medium = typeScale.titleMedium.toTextStyle(fontFamily),
            small = typeScale.titleSmall.toTextStyle(fontFamily),
        ),
        label = SizedTextStyle(
            large = typeScale.labelLarge.toTextStyle(fontFamily),
            medium = typeScale.labelMedium.toTextStyle(fontFamily),
            small = typeScale.labelSmall.toTextStyle(fontFamily),
            extraSmall = typeScale.labelExtraSmall.toTextStyle(fontFamily),
        ),
        body = SizedTextStyle(
            large = typeScale.bodyLarge.toTextStyle(fontFamily),
            medium = typeScale.bodyMedium.toTextStyle(fontFamily),
            small = typeScale.bodySmall.toTextStyle(fontFamily),
        ),
    )
}

private fun TypeToken.toTextStyle(fontFamily: FontFamily): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    fontWeight = fontWeight,
    platformStyle = platformTextStyle,
)