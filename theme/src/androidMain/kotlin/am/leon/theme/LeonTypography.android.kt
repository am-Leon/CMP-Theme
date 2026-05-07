package am.leon.theme

import androidx.compose.ui.text.PlatformTextStyle

/**
 * Android actual: enables includeFontPadding to ensure consistent
 * text baseline alignment with the design system.
 */
internal actual val platformTextStyle: PlatformTextStyle?
    get() = PlatformTextStyle(includeFontPadding = true)