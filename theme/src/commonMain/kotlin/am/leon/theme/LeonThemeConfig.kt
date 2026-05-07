package am.leon.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

/**
 * Contract that every project must implement to use the Leon theme system.
 *
 * The library provides the engine.
 * The project provides the tokens (colors, fonts, type scale).
 */
interface LeonThemeConfig {
    /** Project-specific font family. Must be [@Composable] for CMP font loading. */
    @Composable
    fun fontFamily(): FontFamily

    /** Light semantic color scheme. */
    val lightColors: LeonColors

    /** Dark semantic color scheme. */
    val darkColors: LeonColors

    /** Project type scale (sizes, line heights, weights). */
    val typeScale: TypeScale
}

/** A single type-scale token. */
@Immutable
data class TypeToken(
    val fontSize: TextUnit,
    val lineHeight: TextUnit,
    val fontWeight: FontWeight,
)

/** Complete type scale consumed by [rememberLeonTypography]. */
@Immutable
data class TypeScale(
    val displayLarge: TypeToken,
    val displayMedium: TypeToken,
    val displaySmall: TypeToken,
    val headlineLarge: TypeToken,
    val headlineMedium: TypeToken,
    val headlineSmall: TypeToken,
    val titleLarge: TypeToken,
    val titleMedium: TypeToken,
    val titleSmall: TypeToken,
    val labelLarge: TypeToken,
    val labelMedium: TypeToken,
    val labelSmall: TypeToken,
    val labelExtraSmall: TypeToken,
    val bodyLarge: TypeToken,
    val bodyMedium: TypeToken,
    val bodySmall: TypeToken,
)