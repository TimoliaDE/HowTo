package de.timolia.howto.generator

import de.timolia.howto.translate.Language
import de.timolia.howto.translate.Translate
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import kotlin.Throws

class FileWriter(private val path: Path, private val translate: Translate) {
    @Throws(IOException::class)
    fun writeFile(name: String, text: String) {
        for (language in Language.values()) {
            val translation = translate.forLanguage(language)
            val fileName = name + "." + language.key() + ".md"
            val content = translation.replaceAll(text)
            writeFile(path.resolve(fileName), content)
        }
    }

    companion object {
        @Throws(IOException::class)
        private fun writeFile(path: Path, text: String) {
            path.toFile().parentFile.mkdirs()
            Files.writeString(path, text, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)
            println("Wrote file '$path'")
        }
    }
}
