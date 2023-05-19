package de.timolia.howto.translate

class Translation(private val language: Language, private val key: String, private val value: String) {
    fun replace(text: String): String {
        return text.replace(replacementKey(), value)
    }

    private fun replacementKey(): String {
        return "%$key%"
    }

    override fun toString(): String {
        return "LanguageString{" +
                "language=" + language +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}'
    }
}
