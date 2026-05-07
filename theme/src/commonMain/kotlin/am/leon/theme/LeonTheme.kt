package am.leon.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
 * the project's [LeonThemeConfig] implementation only — no engine file changes.
 */
@Composable
fun LeonTheme(
    config: LeonThemeConfig, darkTheme: Boolean = false, content: @Composable () -> Unit
) {
    val colors = if (darkTheme) config.darkColors else config.lightColors

    val fontFamily = config.fontFamily()
    val typography = rememberLeonTypography(config.typeScale, fontFamily)

    // Build Material3 bridges
    val materialColorScheme = colors.toMaterialColorScheme(darkTheme)
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
// Uses copy() instead of constructor for forward-compatibility with new
// Material3 Expressive roles without breaking on version updates.
//
// Includes **fixed container roles** (Material3 Expressive):
// ┌─────────────────────────┬─────────────────────────────────────────────────┐
// │ Material3 Slot          │ LeonColors Source                               │
// ├─────────────────────────┼─────────────────────────────────────────────────┤
// │ primary                 │ primaryColors.base                              │
// │ onPrimary               │ primaryColors.onBase                            │
// │ primaryContainer        │ primaryColors.containerLight                    │
// │ onPrimaryContainer      │ primaryColors.onContainerLight                  │
// │ inversePrimary          │ primaryColors.containerMedium                   │
// │ primaryFixed            │ primaryColors.fixed                             │
// │ primaryFixedDim         │ primaryColors.fixedDim                          │
// │ onPrimaryFixed          │ primaryColors.onFixed                           │
// │ onPrimaryFixedVariant   │ primaryColors.onFixedDim                        │
// │ secondary               │ secondaryColors.base                            │
// │ onSecondary             │ secondaryColors.onBase                          │
// │ secondaryContainer      │ secondaryColors.containerLight                  │
// │ onSecondaryContainer    │ secondaryColors.onContainerLight                │
// │ secondaryFixed          │ secondaryColors.fixed                           │
// │ secondaryFixedDim       │ secondaryColors.fixedDim                        │
// │ onSecondaryFixed        │ secondaryColors.onFixed                         │
// │ onSecondaryFixedVariant │ secondaryColors.onFixedDim                      │
// │ tertiary                │ tertiaryColors.base                             │
// │ onTertiary              │ tertiaryColors.onBase                           │
// │ tertiaryContainer       │ tertiaryColors.containerLight                   │
// │ onTertiaryContainer     │ tertiaryColors.onContainerLight                 │
// │ tertiaryFixed           │ tertiaryColors.fixed                            │
// │ tertiaryFixedDim        │ tertiaryColors.fixedDim                         │
// │ onTertiaryFixed         │ tertiaryColors.onFixed                          │
// │ onTertiaryFixedVariant  │ tertiaryColors.onFixedDim                       │
// │ background              │ backgroundColors.background                     │
// │ onBackground            │ textColors.base                                 │
// │ surface                 │ backgroundColors.surface                        │
// │ onSurface               │ textColors.base                                 │
// │ surfaceVariant          │ backgroundColors.surface                        │
// │ onSurfaceVariant        │ textColors.disabled                             │
// │ surfaceTint             │ primaryColors.base                              │
// │ inverseSurface          │ textColors.base                                 │
// │ inverseOnSurface        │ backgroundColors.background                     │
// │ error                   │ errorColors.base                                │
// │ onError                 │ errorColors.onBase                              │
// │ errorContainer          │ errorColors.container                           │
// │ onErrorContainer        │ errorColors.onContainer                         │
// │ outline                 │ backgroundColors.stroke                         │
// │ outlineVariant          │ backgroundColors.stroke                         │
// │ scrim                   │ scrimColor                                      │
// └─────────────────────────┴─────────────────────────────────────────────────┘

private fun LeonColors.toMaterialColorScheme(isDark: Boolean): ColorScheme {
    val base = if (isDark) darkColorScheme() else lightColorScheme()

    return base.copy(
        // ── Primary ─────────────────────────────────────────────────────────
        primary = primaryColors.base,
        onPrimary = primaryColors.onBase,
        primaryContainer = primaryColors.containerLight,
        onPrimaryContainer = primaryColors.onContainerLight,
        inversePrimary = primaryColors.containerMedium,

        // Fixed containers (Material3 Expressive)
        primaryFixed = primaryColors.fixed,
        primaryFixedDim = primaryColors.fixedDim,
        onPrimaryFixed = primaryColors.onFixed,
        onPrimaryFixedVariant = primaryColors.onFixedDim,

        // ── Secondary ───────────────────────────────────────────────────────
        secondary = secondaryColors.base,
        onSecondary = secondaryColors.onBase,
        secondaryContainer = secondaryColors.containerLight,
        onSecondaryContainer = secondaryColors.onContainerLight,

        // Fixed containers
        secondaryFixed = secondaryColors.fixed,
        secondaryFixedDim = secondaryColors.fixedDim,
        onSecondaryFixed = secondaryColors.onFixed,
        onSecondaryFixedVariant = secondaryColors.onFixedDim,

        // ── Tertiary ────────────────────────────────────────────────────────
        tertiary = tertiaryColors.base,
        onTertiary = tertiaryColors.onBase,
        tertiaryContainer = tertiaryColors.containerLight,
        onTertiaryContainer = tertiaryColors.onContainerLight,

        // Fixed containers
        tertiaryFixed = tertiaryColors.fixed,
        tertiaryFixedDim = tertiaryColors.fixedDim,
        onTertiaryFixed = tertiaryColors.onFixed,
        onTertiaryFixedVariant = tertiaryColors.onFixedDim,

        // ── Background / Surface ──────────────────────────────────────────
        background = backgroundColors.background,
        onBackground = textColors.base,

        surface = backgroundColors.surface,
        onSurface = textColors.base,
        surfaceVariant = backgroundColors.surface,
        onSurfaceVariant = textColors.disabled,
        surfaceTint = primaryColors.base,
        inverseSurface = textColors.base,
        inverseOnSurface = backgroundColors.background,

        // ── Error ───────────────────────────────────────────────────────────
        error = errorColors.base,
        onError = errorColors.onBase,
        errorContainer = errorColors.container,
        onErrorContainer = errorColors.onContainer,

        // ── Outline ─────────────────────────────────────────────────────────
        outline = backgroundColors.stroke,
        outlineVariant = backgroundColors.stroke,

        // ── Scrim ───────────────────────────────────────────────────────────
        scrim = scrimColor,
    )
}

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