package de.timolia.howto.translate

fun interface TranslationContext {
    fun replaceAll(content: String): String
}
