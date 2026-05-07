package am.leon.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.font.FontFamily

/**
 * The single Compose theme wrapper for the entire application.
 *
 * Provides:
 *   - Custom [LeonColors] via [LocalLeonColors]         → [LeonTheme.colors]
 *   - Custom [LeonTypography] via [LocalLeonTypography] → [LeonTheme.typography]
 *   - Material3 [MaterialTheme] bridge (colors + typography) so all
 *     Material3 components automatically inherit the app font and palette.
 *
 * To change the font or color palette for a different project, update
 * [LeonThemeConfig] only — no other file needs to change.
 */
@Composable
fun LeonTheme(
    config: LeonThemeConfig, darkTheme: Boolean = false, content: @Composable () -> Unit
) {
    val colors = if (darkTheme) config.darkColors else config.lightColors

    val fontFamily = config.fontFamily()
    val typography = rememberLeonTypography(config.typeScale, fontFamily)

    val materialColorScheme = colors.toMaterialColorScheme()
    val materialTypography = rememberMaterialTypography(fontFamily)

    CompositionLocalProvider(
        LocalLeonColors provides colors,
        LocalLeonTypography provides typography,
        LocalTextStyle provides typography.body.medium,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme, typography = materialTypography, content = content
        )
    }
}

/**
 * Accessor object for reading theme tokens from any composable.
 *
 * Usage:
 * ```
 *   val color = LeonTheme.colors.primaryColors.base
 *   val style = LeonTheme.typography.headline.large
 * ```
 */
object LeonTheme {
    val colors: LeonColors
        @Composable @ReadOnlyComposable get() = LocalLeonColors.current

    val typography: LeonTypography
        @Composable @ReadOnlyComposable get() = LocalLeonTypography.current
}

// ── Material3 Color Bridge ────────────────────────────────────────────────────
//
// Maps semantic LeonColors tokens to Material3 ColorScheme slots so that
// Material3 components (Button, TextField, etc.) automatically use app colors.
//
// ┌──────────────────────┬────────────────────────────────────────────┐
// │ Material3 Slot       │ LeonColors Source                           │
// ├──────────────────────┼────────────────────────────────────────────┤
// │ primary              │ primaryColors.base                         │
// │ onPrimary            │ primaryColors.onBase                       │
// │ primaryContainer     │ primaryColors.containerLight               │
// │ onPrimaryContainer   │ primaryColors.onContainerLight             │
// │ inversePrimary       │ primaryColors.containerMedium              │
// │ secondary            │ secondaryColors.base                       │
// │ onSecondary          │ secondaryColors.onBase                     │
// │ secondaryContainer   │ secondaryColors.containerLight             │
// │ onSecondaryContainer │ secondaryColors.onContainerLight           │
// │ tertiary             │ tertiaryColors.base                        │
// │ onTertiary           │ tertiaryColors.onBase                      │
// │ tertiaryContainer    │ tertiaryColors.containerLight              │
// │ onTertiaryContainer  │ tertiaryColors.onContainerLight            │
// │ background           │ backgroundColors.background                │
// │ onBackground         │ textColors.base                            │
// │ surface              │ backgroundColors.surface                   │
// │ onSurface            │ textColors.base                            │
// │ surfaceVariant       │ backgroundColors.surface                   │
// │ onSurfaceVariant     │ textColors.disabled                        │
// │ surfaceTint          │ primaryColors.base                         │
// │ inverseSurface       │ textColors.base                            │
// │ inverseOnSurface     │ backgroundColors.background                │
// │ error                │ errorColors.base                           │
// │ onError              │ errorColors.onBase                         │
// │ errorContainer       │ errorColors.container                      │
// │ onErrorContainer     │ errorColors.onContainer                    │
// │ outline              │ backgroundColors.stroke                    │
// │ outlineVariant       │ backgroundColors.stroke                    │
// │ scrim                │ scrimColor                                 │
// └──────────────────────┴────────────────────────────────────────────┘

private fun LeonColors.toMaterialColorScheme(): ColorScheme = ColorScheme(
    primary = primaryColors.base,
    onPrimary = primaryColors.onBase,
    primaryContainer = primaryColors.containerLight,
    onPrimaryContainer = primaryColors.onContainerLight,
    inversePrimary = primaryColors.containerMedium,

    secondary = secondaryColors.base,
    onSecondary = secondaryColors.onBase,
    secondaryContainer = secondaryColors.containerLight,
    onSecondaryContainer = secondaryColors.onContainerLight,

    tertiary = tertiaryColors.base,
    onTertiary = tertiaryColors.onBase,
    tertiaryContainer = tertiaryColors.containerLight,
    onTertiaryContainer = tertiaryColors.onContainerLight,

    background = backgroundColors.background,
    onBackground = textColors.base,

    surface = backgroundColors.surface,
    onSurface = textColors.base,
    surfaceVariant = backgroundColors.surface,
    onSurfaceVariant = textColors.disabled,
    surfaceTint = primaryColors.base,
    inverseSurface = textColors.base,
    inverseOnSurface = backgroundColors.background,

    error = errorColors.base,
    onError = errorColors.onBase,
    errorContainer = errorColors.container,
    onErrorContainer = errorColors.onContainer,

    outline = backgroundColors.stroke,
    outlineVariant = backgroundColors.stroke,

    scrim = scrimColor,
    surfaceBright = backgroundColors.surface,
    surfaceDim = backgroundColors.surface,
    surfaceContainer = backgroundColors.surface,
    surfaceContainerHigh = backgroundColors.surface,
    surfaceContainerHighest = backgroundColors.surface,
    surfaceContainerLow = backgroundColors.background,
    surfaceContainerLowest = backgroundColors.background,
)

// ── Material3 Typography Bridge ───────────────────────────────────────────────
//
// Applies the app font family to all Material3 Typography slots so that
// Material3 components inherit the custom font automatically.

@Composable
private fun rememberMaterialTypography(fontFamily: FontFamily): Typography {
    val base = Typography()
    return base.copy(
        displayLarge = base.displayLarge.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        displayMedium = base.displayMedium.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        displaySmall = base.displaySmall.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        headlineLarge = base.headlineLarge.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        headlineMedium = base.headlineMedium.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        headlineSmall = base.headlineSmall.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        titleLarge = base.titleLarge.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        titleMedium = base.titleMedium.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        titleSmall = base.titleSmall.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        bodyLarge = base.bodyLarge.copy(fontFamily = fontFamily, platformStyle = platformTextStyle),
        bodyMedium = base.bodyMedium.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        bodySmall = base.bodySmall.copy(fontFamily = fontFamily, platformStyle = platformTextStyle),
        labelLarge = base.labelLarge.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        labelMedium = base.labelMedium.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        ),
        labelSmall = base.labelSmall.copy(
            fontFamily = fontFamily, platformStyle = platformTextStyle
        )
    )
}