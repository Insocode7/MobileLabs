package com.example.reply

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureScreenRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/** Адаптивный макет Reply на планшете (Expanded) и складном экране (Medium). */
@OptIn(ExperimentalRoborazziApi::class)
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class AdaptiveScreenshotTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    @Config(sdk = [34], qualifiers = RobolectricDeviceQualifiers.MediumTablet)
    fun tabletLayout() {
        rule.waitForIdle()
        captureScreenRoboImage("../screenshots/reply_3_tablet_expanded.png")
    }

    @Test
    @Config(sdk = [34], qualifiers = "w700dp-h900dp-xhdpi")
    fun foldableLayout() {
        rule.waitForIdle()
        captureScreenRoboImage("../screenshots/reply_4_foldable_medium.png")
    }
}
