# Лабораторные работы по курсу Android Basics with Compose

Решения практических заданий курса Android Basics with Compose.

| Папка | Unit курса | Модули |
|---|---|---|
| [lab2](lab2) | Unit 2: Building app UI | `diceroller` (Dice Roller), `tiptime` (Tip Time), `artspace` (Art Space) |
| [lab3](lab3) | Unit 3: Display lists and use Material Design | `kotlin-basics` (More Kotlin fundamentals, консоль), `affirmations`, `woof` |
| [lab4](lab4) | Unit 4: Navigation and app architecture | `unscramble`, `cupcake`, `reply` |

## Запуск

Откройте нужную папку (например, `lab2`) в Android Studio и запустите модуль.

Из командной строки, внутри папки лабы:

```
gradlew assembleDebug                                   # сборка APK всех модулей
gradlew testDebugUnitTest                               # unit-тесты
gradlew testDebugUnitTest -Proborazzi.test.record=true  # пересоздать скриншоты в screenshots/
gradlew :kotlin-basics:run                              # лаба 3: итоговое решение Practice
gradlew :kotlin-basics:checkSolutions                   # лаба 3: проверка решений
```

Скриншоты работы приложений лежат в папке `screenshots` каждой лабы.
