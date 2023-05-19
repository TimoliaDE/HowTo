package de.timolia.howto.translate

enum class Language {
    DE,
    EN;

    fun key(): String {
        return name.lowercase()
    }
}
