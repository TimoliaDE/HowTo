package de.timolia.howto.translate

class Translation(private val language: Language, private val key: String, private val value: String) {
    fun replace(text: String) = text.replace(replacementKey(), value)

    private fun replacementKey() = "%$key%"

    override fun toString(): String {
        return "LanguageString{" +
                "language=" + language +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}'
    }
}
