// Консольный Kotlin/JVM-модуль: Unit 3, Pathway 1 «More Kotlin fundamentals».
plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("practice.complete.MainKt")
}

// Отдельная задача для каждой программы: gradlew :kotlin-basics:task4, :kotlin-basics:demoGenerics и т. д.
val programs = mapOf(
    "demoGenerics" to "lessons.generics.MainKt",
    "demoCollections" to "lessons.collections.MainKt",
    "demoFunctions" to "lessons.functions.MainKt",
    "checkSolutions" to "verification.MainKt"
) + (1..7).associate { "task$it" to "practice.task$it.MainKt" }
programs.forEach { (taskName, entryPoint) ->
    tasks.register<JavaExec>(taskName) {
        group = "learning"
        description = "Run $entryPoint"
        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set(entryPoint)
        jvmArgs("-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dstdout.encoding=UTF-8")
    }
}

tasks.named<JavaExec>("run") {
    jvmArgs("-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dstdout.encoding=UTF-8")
}
