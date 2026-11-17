package lessons.functions

// Double здесь оставлен как в учебном задании.
// Форматирование ниже даёт ровно два знака после точки.
data class Cookie(val name: String, val softBaked: Boolean, val hasFilling: Boolean, val price: Double)
val cookies = listOf(
    Cookie("Chocolate Chip", false, false, 1.69),
    Cookie("Banana Walnut", true, false, 1.49),
    Cookie("Vanilla Creme", false, true, 1.59),
    Cookie("Chocolate Peanut Butter", false, true, 1.49),
    Cookie("Snickerdoodle", true, false, 1.39),
    Cookie("Blueberry Tart", true, true, 1.79),
    Cookie("Sugar and Sprinkles", false, false, 1.39)
)
fun main() {
    println("FOR EACH")
    cookies.forEach { println("Menu item: ${it.name}") }

    println("\nMAP: Full menu")
    val fullMenu = cookies.map { "${it.name} - $${it.price}" }
    fullMenu.forEach { println(it) }

    println("\nFILTER: Soft cookies")
    val softBakedMenu = cookies.filter { it.softBaked }
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }

    println("\nGROUP BY")
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softCookies = groupedMenu[true] ?: emptyList()
    val crunchyCookies = groupedMenu[false] ?: emptyList()
    println("Soft cookies:")
    softCookies.forEach { println(it.name) }
    println("Crunchy cookies:")
    crunchyCookies.forEach { println(it.name) }

    println("\nFOLD")
    val totalPrice = cookies.fold(0.0) { total, cookie -> total + cookie.price }
    println("Total price: $${"%.2f".format(java.util.Locale.US, totalPrice)}")

    println("\nSORTED BY: Alphabetical menu")
    val alphabeticalMenu = cookies.sortedBy { it.name }
    alphabeticalMenu.forEach { println(it.name) }
}
