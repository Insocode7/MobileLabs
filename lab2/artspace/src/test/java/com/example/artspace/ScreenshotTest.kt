package com.example.artspace

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
 * Запуск: gradlew :artspace:testDebugUnitTest -Proborazzi.test.record=true
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
        captureScreenRoboImage("../screenshots/artspace_$name.png")
    }

    @Test
    fun browseGallery() {
        shot("1_first")
        rule.onNodeWithText("Вперёд").performClick()
        shot("2_second")
        rule.onNodeWithText("Назад").performClick()
        rule.onNodeWithText("Назад").performClick()
        shot("3_last_cyclic")
    }
}
