package am.leon.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalLeonColors = staticCompositionLocalOf<LeonColors> { error("Cannot provide colors") }

/**
 * A complete color family for a single theme accent (Primary, Secondary, Tertiary).
 *
 * Each project maps its raw palette into these semantic slots inside [LeonThemeConfig].
 */
data class ThemedColors(
    /** Main action color. Used for: Filled buttons, active switches, selected tabs, key CTAs, progress indicators. */
    val base: Color = Color.Unspecified,

    /** Content (text / icons) that sits **on top of** [base]. Must guarantee contrast. */
    val onBase: Color = Color.Unspecified,

    /** Medium-emphasis container. Used for: Selected chips, active tab backgrounds, medium-promotion cards, drag-highlight. */
    val containerMedium: Color = Color.Unspecified,

    /** Content that sits **on top of** [containerMedium]. */
    val onContainerMedium: Color = Color.Unspecified,

    /** Low-emphasis / subtle container. Used for: Badges, hover states, subtle row highlights, empty-state illustrations background. */
    val containerLight: Color = Color.Unspecified,

    /** Content that sits **on top of** [containerLight]. */
    val onContainerLight: Color = Color.Unspecified,

    /** Container consistent regardless of surface color (banners, date picker selections) */
    val fixed: Color = Color.Unspecified,

    /** Content that sits **on top of** [fixed]. */
    val onFixed: Color = Color.Unspecified,

    /** Dimmed fixed container. Layered emphasis below [fixed] */
    val fixedDim: Color = Color.Unspecified,

    /** Content that sits **on top of** [fixedDim]. */
    val onFixedDim: Color = Color.Unspecified,

    /** Disabled state for interactive elements belonging to this color family. */
    val disabled: Color = Color.Unspecified,

    /** Content that sits **on top of** [disabled]. */
    val onDisabled: Color = Color.Unspecified,
)

/**
 * Semantic colors for a status / feedback category.
 *
 * Used for alerts, validation, badges, banners, and inline messaging.
 */
data class StatusColors(
    /** The status indicator itself. Used for: Error text, success icons, warning triangles, info badges. */
    val base: Color = Color.Unspecified,

    /** Content on top of [base]. Usually white or near-black depending on luminance. */
    val onBase: Color = Color.Unspecified,

    /** Background for status messaging. Used for: Alert banners, toast backgrounds, status pills, snack-bars. */
    val container: Color = Color.Unspecified,

    /** Text / icons inside the status container (e.g. banner message text). */
    val onContainer: Color = Color.Unspecified,
)

/**
 * Structural colors that define the "canvas" of the app.
 */
data class BackgroundColors(
    /** Dividers, thin borders, outline buttons, separator lines, table borders. */
    val stroke: Color = Color.Unspecified,

    /** Elevated surfaces. Used for: Cards, bottom sheets, dialogs, menus, pop-ups, elevated buttons. */
    val surface: Color = Color.Unspecified,

    /** The root background behind all content. Used for: Scaffold background, empty page background, splash screen. */
    val background: Color = Color.Unspecified,
)

/**
 * Text-specific colors. Kept separate from [BackgroundColors] to allow
 * high-contrast or accessible themes to remap independently.
 */
data class TextColors(
    /** Primary text. Used for: Headlines, body copy, input text, active labels, toolbar titles. */
    val base: Color = Color.Unspecified,

    /** Non-interactive / muted text. Used for: Hints, placeholders, disabled labels, captions, secondary metadata. */
    val disabled: Color = Color.Unspecified,
)

/**
 * Specialized colors for input fields so forms can be themed independently
 * of the global text and stroke colors.
 */
data class TextFieldColors(
    /** Border / outline of a text field in its default or focused state. */
    val stroke: Color = Color.Unspecified,

    /** Typed text, cursor, and floating label when focused. */
    val content: Color = Color.Unspecified,

    /** Border when the field is disabled or read-only. */
    val disabledStroke: Color = Color.Unspecified,

    /** Text inside a disabled field. */
    val disabledContent: Color = Color.Unspecified,
)

/**
 * Expanded color container for generic reuse across any project.
 *
 * Add new fields here (e.g. chart colors, surface tints) if a project needs them —
 * the engine files do not need to change.
 *
 * ## Usage Guide
 * | Field | Typical UI Elements |
 * |-------|---------------------|
 * | [primaryColors] | Main CTA buttons, active navigation, progress, links |
 * | [secondaryColors] | Secondary actions, filters, alternative buttons, promotional accents |
 * | [tertiaryColors] | Calendar selections, accent chips, decorative highlights, contrast accents |
 * | [errorColors] | Validation errors, destructive actions, critical alerts |
 * | [successColors] | Success toasts, completed states, positive badges, checkmarks |
 * | [warningColors] | Caution banners, unsaved changes, medium-severity alerts |
 * | [infoColors] | Help tooltips, info banners, blue badges, hints, neutral links |
 * | [backgroundColors] | Page backgrounds, cards, dividers |
 * | [textColors] | All text hierarchy: headings, body, hints, disabled |
 * | [textFieldColors] | Form inputs, search bars, dropdowns |
 * | [switchDisabledColor] | Switch track / thumb when the component is disabled |
 * | [unselectedIconColor] | Bottom-nav icons, unselected tabs, unchecked checkboxes, inactive toggles |
 * | [scrimColor] | Modal backdrop, bottom-sheet overlay, dialog dim, image overlay |
 */
data class LeonColors(
    val primaryColors: ThemedColors = ThemedColors(),
    val secondaryColors: ThemedColors = ThemedColors(),
    val tertiaryColors: ThemedColors = ThemedColors(),
    val errorColors: StatusColors = StatusColors(),
    val successColors: StatusColors = StatusColors(),
    val warningColors: StatusColors = StatusColors(),
    val infoColors: StatusColors = StatusColors(),
    val backgroundColors: BackgroundColors = BackgroundColors(),
    val textColors: TextColors = TextColors(),
    val textFieldColors: TextFieldColors = TextFieldColors(),
    val switchDisabledColor: Color = Color.Unspecified,
    val unselectedIconColor: Color = Color.Unspecified,
    val scrimColor: Color = Color.Unspecified,
)