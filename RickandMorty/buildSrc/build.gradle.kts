plugins {
    `kotlin-dsl`
}

repositories {
    // The org.jetbrains.kotlin.jvm plugin requires a repository
    // where to download the Kotlin compiler dependencies from.
    // https://github.com/gradle/kotlin-dsl/issues/1033
    jcenter()
}