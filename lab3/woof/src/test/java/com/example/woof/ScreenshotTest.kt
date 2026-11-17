package com.example.woof

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
 * Запуск: gradlew :woof:testDebugUnitTest -Proborazzi.test.record=true
 */
@OptIn(ExperimentalRoborazziApi::class)
@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [34], qualifiers = "w393dp-h851dp-mdpi")
class ScreenshotTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    private fun shot(name: String) {
        rule.waitForIdle()
        captureScreenRoboImage("../screenshots/woof_$name.png")
    }

    @Test
    fun expandDog() {
        shot("1_list")
        rule.onAllNodesWithContentDescription("See more or less information about a dog.").onFirst().performClick()
        rule.mainClock.advanceTimeBy(1000)
        shot("2_expanded")
    }
}
