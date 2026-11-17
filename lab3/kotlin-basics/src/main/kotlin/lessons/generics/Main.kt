package lessons.generics

enum class Difficulty { EASY, MEDIUM, HARD }
data class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty)

object CourseInfo { val title = "More Kotlin fundamentals" }

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    // Это учебный пример из курса, а не астрономическая справка.
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // Общее состояние класса: Quiz.answered, без создания Quiz().
    companion object StudentProgress {
        var total = 10
        var answered = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
    }
}

// Расширения добавляют синтаксис вызова, но не изменяют исходный класс.
// У расширения нет собственного поля для хранения значения.
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
    println(progressText)
}

fun main() {
    println(CourseInfo.title)
    val quiz = Quiz().apply { printQuiz() } // apply возвращает сам Quiz.
    println()
    println(quiz.question1) // data class генерирует читаемый toString().
    println(quiz.question1.copy(answer = "forever"))
    println("Interface implementation:")
    quiz.printProgressBar()
    println("Companion object extension:")
    Quiz.printProgressBar()
}
