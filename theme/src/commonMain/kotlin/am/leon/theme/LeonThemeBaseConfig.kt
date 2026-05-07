package am.leon.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ── Engine imports (from the lib) ─────────────────────────────────────────────

import am.leon.theme.LeonThemeConfig
import am.leon.theme.TypeScale
import am.leon.theme.TypeToken
import am.leon.theme.LeonColors
import am.leon.theme.ThemedColors
import am.leon.theme.StatusColors
import am.leon.theme.BackgroundColors
import am.leon.theme.TextColors
import am.leon.theme.TextFieldColors

// ── Project-specific imports (uncomment and adapt per project) ────────────────
//
// import androidx.compose.ui.text.font.Font
// import your.project.package.R                      // Android-only
// import your.project.package.generated.resources.Res // CMP

/**
 * PROJECT-SPECIFIC THEME CONFIGURATION — Copy & Modify Template
 *
 * This file lives in the **lib as a reference only**.
 * For each new project:
 *   1. Copy this file into the project's source tree.
 *   2. Uncomment the font loading block below and point to your project's fonts.
 *   3. Replace the raw [Palette] hex values with the project's brand colors.
 *   4. Adjust [typeScale] tokens if the design system uses different sizes.
 *
 * The engine files (LeonTheme, LeonTypography, LeonColorScheme) stay untouched.
 *
 * ## Compose Multiplatform (CMP)
 * ```
 * @Composable
 * override fun fontFamily(): FontFamily = FontFamily(
 *     Font(Res.font.your_font_regular, FontWeight.Normal),
 *     Font(Res.font.your_font_medium, FontWeight.Medium),
 *     Font(Res.font.your_font_bold, FontWeight.Bold),
 * )
 * ```
 *
 * ## Standard Android Compose
 * ```
 * @Composable
 * override fun fontFamily(): FontFamily = FontFamily(
 *     Font(R.font.your_font_regular, FontWeight.Normal),
 *     Font(R.font.your_font_medium, FontWeight.Medium),
 *     Font(R.font.your_font_bold, FontWeight.Bold),
 * )
 * ```
 *
 * ══════════════════════════════════════════════════
 *  ## COLOR FILLING GUIDE — Where each semantic slot reflects in the UI
 * ══════════════════════════════════════════════════
 *
 * | Field               | Typical UI Elements                                      |
 * |---------------------|----------------------------------------------------------|
 * | [LeonColors.primaryColors]     | Main CTA buttons, active navigation, progress, links       |
 * | [LeonColors.secondaryColors]   | Secondary actions, filters, alternative buttons, promo    |
 * | [LeonColors.tertiaryColors]    | Calendar selections, accent chips, decorative highlights  |
 * | [LeonColors.errorColors]       | Validation errors, destructive actions, critical alerts   |
 * | [LeonColors.successColors]     | Success toasts, completed states, positive badges         |
 * | [LeonColors.warningColors]     | Caution banners, unsaved changes, medium-severity alerts  |
 * | [LeonColors.infoColors]        | Help tooltips, info banners, blue badges, hints           |
 * | [LeonColors.backgroundColors]  | Page backgrounds, cards, dividers                         |
 * | [LeonColors.textColors]        | All text hierarchy: headings, body, hints, disabled       |
 * | [LeonColors.textFieldColors]   | Form inputs, search bars, dropdowns                       |
 * | [LeonColors.switchDisabledColor] | Switch track / thumb when the component is disabled     |
 * | [LeonColors.unselectedIconColor] | Bottom-nav icons, unselected tabs, unchecked checkboxes |
 * | [LeonColors.scrimColor]        | Modal backdrop, bottom-sheet overlay, dialog dim          |
 */
object LeonThemeBaseConfig : LeonThemeConfig {

    // ═══════════════════════════════════════════════════════════════════════════
    //  FONTS — TODO: Uncomment and replace with your project's font resources
    // ═══════════════════════════════════════════════════════════════════════════

    @Composable
    override fun fontFamily(): FontFamily {
        // TODO: Replace with project-specific font loading.
        // Returning Default as a placeholder so the file compiles in the lib.
        return FontFamily.Default

        // ── CMP Example ───────────────────────────────────────────────────────
        // return FontFamily(
        //     Font(Res.font.your_font_regular, FontWeight.Normal),
        //     Font(Res.font.your_font_medium, FontWeight.Medium),
        //     Font(Res.font.your_font_bold, FontWeight.Bold),
        //     Font(Res.font.your_font_extra_bold, FontWeight.ExtraBold),
        //     Font(Res.font.your_font_black, FontWeight.Black),
        // )

        // ── Android Example ───────────────────────────────────────────────────
        // return FontFamily(
        //     Font(R.font.your_font_regular, FontWeight.Normal),
        //     Font(R.font.your_font_medium, FontWeight.Medium),
        //     Font(R.font.your_font_bold, FontWeight.Bold),
        //     Font(R.font.your_font_extra_bold, FontWeight.ExtraBold),
        //     Font(R.font.your_font_black, FontWeight.Black),
        // )
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  RAW PALETTE
    //  Replace these hex values with the new project's brand palette.
    // ═══════════════════════════════════════════════════════════════════════════

    object Palette {
        // Primary — Your brand's hero color
        val Primary10 = Color(0xFFC3DBFF) // Very light tint (hover, badges)
        val Primary50 = Color(0xFFC3DBFE) // Light tint (subtle backgrounds)
        val Primary100 = Color(0xFF0F6FFD) // Core brand color (buttons, links)

        // Secondary — Supporting accent
        val Secondary10 = Color(0xFFE5F2CE)
        val Secondary50 = Color(0xFFCCE59D)
        val Secondary100 = Color(0xFF99CB3B)

        // Tertiary — Decorative / alternative accent (Material3 standard)
        val Tertiary10 = Color(0xFFFFE5F0)
        val Tertiary50 = Color(0xFFFFB3D9)
        val Tertiary100 = Color(0xFFFF66B2)

        // Neutral — Greys for structure, text, and disabled states
        val Neutral50 = Color(0xFFFAFAFA) // Lightest surface
        val Neutral100 = Color(0xFFF5F5F5) // Light surface (cards in light mode)
        val Neutral200 = Color(0xFFEEEEEE) // Dividers (light)
        val Neutral225 = Color(0xFFE6E6E6) // Switch disabled track
        val Neutral250 = Color(0xFFB6B6B6)
        val Neutral300 = Color(0xFFBDBDBD) // Disabled text / borders
        val Neutral400 = Color(0xFFA5A5A5) // Hints, captions
        val Neutral500 = Color(0xFF9E9E9E) // Unselected icons
        val Neutral600 = Color(0xFF757575) // Disabled dark-mode surfaces
        val Neutral700 = Color(0xFF616161) // Dark-mode strokes
        val Neutral800 = Color(0xFF424242) // Dark-mode cards
        val Neutral900 = Color(0xFF212121) // Dark-mode background

        // States — Feedback colors (keep semantic meaning, swap hues per brand)
        val Success50 = Color(0xFFDFFFE1)
        val Success100 = Color(0xFF08C86F)
        val Error50 = Color(0xFFFEE6EC)
        val Error100 = Color(0xFFE31414)
        val Warning50 = Color(0xFFFDF7DE)
        val Warning100 = Color(0xFFFBCA05)
        val Info50 = Color(0xFFE3F2FD)
        val Info100 = Color(0xFF2196F3)
    }

    // ═══════════════════════════════════════════════════════════════════════════
    //  SEMANTIC — LIGHT
    //  Map the raw palette above into semantic slots used by the UI.
    //  When the designer changes a button color, edit the mapping below only.
    // ═══════════════════════════════════════════════════════════════════════════

    override val lightColors: LeonColors
        get() = LeonColors(
            primaryColors = ThemedColors(
                base = Palette.Primary100,
                onBase = Color.White,
                containerMedium = Palette.Primary50,
                onContainerMedium = Palette.Primary100,
                containerLight = Palette.Primary10,
                onContainerLight = Palette.Primary100,
                disabled = Palette.Neutral300,
                onDisabled = Color.White,
            ),
            secondaryColors = ThemedColors(
                base = Palette.Secondary100,
                onBase = Color.White,
                containerMedium = Palette.Secondary50,
                onContainerMedium = Palette.Secondary100,
                containerLight = Palette.Secondary10,
                onContainerLight = Palette.Secondary100,
                disabled = Palette.Neutral300,
                onDisabled = Color.White,
            ),
            tertiaryColors = ThemedColors(
                base = Palette.Tertiary100,
                onBase = Color.White,
                containerMedium = Palette.Tertiary50,
                onContainerMedium = Palette.Tertiary100,
                containerLight = Palette.Tertiary10,
                onContainerLight = Palette.Tertiary100,
                disabled = Palette.Neutral300,
                onDisabled = Color.White,
            ),
            errorColors = StatusColors(
                base = Palette.Error100,
                onBase = Color.White,
                container = Palette.Error50,
                onContainer = Palette.Error100,
            ),
            successColors = StatusColors(
                base = Palette.Success100,
                onBase = Color.White,
                container = Palette.Success50,
                onContainer = Palette.Success100,
            ),
            warningColors = StatusColors(
                base = Palette.Warning100,
                onBase = Color.Black,
                container = Palette.Warning50,
                onContainer = Palette.Warning100,
            ),
            infoColors = StatusColors(
                base = Palette.Info100,
                onBase = Color.White,
                container = Palette.Info50,
                onContainer = Palette.Info100,
            ),
            backgroundColors = BackgroundColors(
                background = Color.White,
                surface = Palette.Neutral100,
                stroke = Palette.Neutral400,
            ),
            textColors = TextColors(
                base = Color.Black,
                disabled = Palette.Neutral400,
            ),
            textFieldColors = TextFieldColors(
                stroke = Palette.Neutral400,
                content = Palette.Neutral600,
                disabledStroke = Palette.Neutral300,
                disabledContent = Palette.Neutral300,
            ),
            switchDisabledColor = Palette.Neutral225,
            unselectedIconColor = Palette.Neutral500,
            scrimColor = Color.Black.copy(alpha = 0.32f),
        )

    // ═══════════════════════════════════════════════════════════════════════════
    //  SEMANTIC — DARK
    //  Mirror the light scheme with dark-appropriate surfaces and text.
    // ═══════════════════════════════════════════════════════════════════════════

    override val darkColors: LeonColors
        get() = LeonColors(
            primaryColors = ThemedColors(
                base = Palette.Primary100,
                onBase = Color.White,
                containerMedium = Palette.Primary50,
                onContainerMedium = Color.Black,
                containerLight = Palette.Primary10,
                onContainerLight = Color.Black,
                disabled = Palette.Neutral600,
                onDisabled = Color.Black,
            ),
            secondaryColors = ThemedColors(
                base = Palette.Secondary100,
                onBase = Color.Black,
                containerMedium = Palette.Secondary50,
                onContainerMedium = Color.Black,
                containerLight = Palette.Secondary10,
                onContainerLight = Color.Black,
                disabled = Palette.Neutral600,
                onDisabled = Color.Black,
            ),
            tertiaryColors = ThemedColors(
                base = Palette.Tertiary100,
                onBase = Color.Black,
                containerMedium = Palette.Tertiary50,
                onContainerMedium = Color.Black,
                containerLight = Palette.Tertiary10,
                onContainerLight = Color.Black,
                disabled = Palette.Neutral600,
                onDisabled = Color.Black,
            ),
            errorColors = StatusColors(
                base = Palette.Error100,
                onBase = Color.White,
                container = Palette.Error50,
                onContainer = Palette.Error100,
            ),
            successColors = StatusColors(
                base = Palette.Success100,
                onBase = Color.Black,
                container = Palette.Success50,
                onContainer = Palette.Success100,
            ),
            warningColors = StatusColors(
                base = Palette.Warning100,
                onBase = Color.Black,
                container = Palette.Warning50,
                onContainer = Palette.Warning100,
            ),
            infoColors = StatusColors(
                base = Palette.Info100,
                onBase = Color.White,
                container = Palette.Info50,
                onContainer = Palette.Info100,
            ),
            backgroundColors = BackgroundColors(
                background = Palette.Neutral900,
                surface = Palette.Neutral800,
                stroke = Palette.Neutral600,
            ),
            textColors = TextColors(
                base = Color.White,
                disabled = Palette.Neutral500,
            ),
            textFieldColors = TextFieldColors(
                stroke = Palette.Neutral500,
                content = Palette.Neutral300,
                disabledStroke = Palette.Neutral700,
                disabledContent = Palette.Neutral700,
            ),
            switchDisabledColor = Palette.Neutral700,
            unselectedIconColor = Palette.Neutral400,
            scrimColor = Color.Black.copy(alpha = 0.60f),
        )

    // ═══════════════════════════════════════════════════════════════════════════
    //  TYPOGRAPHY SCALE
    //  Edit these tokens when the designer changes font sizes.
    //  The engine will rebuild every text style automatically.
    // ═══════════════════════════════════════════════════════════════════════════

    override val typeScale: TypeScale
        get() = TypeScale(
            displayLarge    = TypeToken(fontSize = 22.sp, lineHeight = 28.sp, fontWeight = FontWeight.Black),
            displayMedium   = TypeToken(fontSize = 20.sp, lineHeight = 26.sp, fontWeight = FontWeight.Bold),
            displaySmall    = TypeToken(fontSize = 18.sp, lineHeight = 24.sp, fontWeight = FontWeight.Black),
            headlineLarge   = TypeToken(fontSize = 18.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold),
            headlineMedium  = TypeToken(fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold),
            headlineSmall   = TypeToken(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold),
            titleLarge      = TypeToken(fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
            titleMedium     = TypeToken(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
            titleSmall      = TypeToken(fontSize = 12.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
            labelLarge      = TypeToken(fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold),
            labelMedium     = TypeToken(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
            labelSmall      = TypeToken(fontSize = 12.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold),
            labelExtraSmall = TypeToken(fontSize = 12.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium),
            bodyLarge       = TypeToken(fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Normal),
            bodyMedium      = TypeToken(fontSize = 14.sp, lineHeight = 20.sp, fontWeight = FontWeight.Normal),
            bodySmall       = TypeToken(fontSize = 12.sp, lineHeight = 17.sp, fontWeight = FontWeight.Normal)
        )
}