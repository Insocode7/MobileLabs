package com.example.unscramble

import androidx.compose.ui.test.*
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

/**
 * Сценарий работы приложения для отчёта: запускается MainActivity, тест выполняет действия
 * пользователя и после каждого шага сохраняет скриншот в папку screenshots/ лабы.
 * Запуск: gradlew :unscramble:testDebugUnitTest -Proborazzi.test.record=true
 */
@OptIn(ExperimentalRoborazziApi::class)
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [34], qualifiers = RobolectricDeviceQualifiers.Pixel5)
class ScreenshotTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    private fun shot(name: String) {
        rule.waitForIdle()
        captureScreenRoboImage("../screenshots/unscramble_$name.png")
    }

    @Test
    fun playGame() {
        shot("1_start")
        rule.onNodeWithText("Enter your word").performTextInput("qwerty")
        rule.onNodeWithText("Submit").performClick()
        shot("2_wrong_guess")
        rule.onNodeWithText("Skip").performClick()
        shot("3_after_skip")
        repeat(9) { rule.onNodeWithText("Skip").performClick() }
        shot("4_game_over_dialog")
    }
}
