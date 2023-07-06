package de.timolia.howto.translate

enum class Language {
    DE,
    EN;

    fun key() = name.lowercase()
}
