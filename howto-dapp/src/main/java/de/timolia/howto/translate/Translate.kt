package de.timolia.howto.translate

import java.io.IOException
import java.io.UncheckedIOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.stream.Collectors
import kotlin.Throws
import kotlin.io.path.extension
import kotlin.io.path.nameWithoutExtension

class Translate {
    private val translations = EnumMap<Language, MutableList<Translation>>(Language::class.java)
    @Throws(IOException::class)
    fun loadDirectory(path: Path) {
        Files.list(path).forEach { file: Path ->
            try {
                mayLoadFile(file)
            } catch (e: IOException) {
                throw UncheckedIOException("Failed to load translation from $file", e)
            }
        }
    }

    @Throws(IOException::class)
    private fun mayLoadFile(path: Path) {
        if (path.extension != "properties") {
            return
        }
        val languageName = path.nameWithoutExtension
        val language = Language.valueOf(languageName.uppercase())
        println(languageName)
        val properties = Properties()
        properties.load(Files.newBufferedReader(path, StandardCharsets.UTF_8))
        translations[language] = properties.entries
                .map { property -> Translation(language, property.key.toString(), property.value.toString()) }
                .toMutableList()
    }

    fun forLanguage(language: Language): TranslationContext {
        val translations = translations[language]
                ?: throw IllegalArgumentException("No translations for language $language")
        return TranslationContext { content ->
            var content = content
            for (translation in translations) {
                content = translation.replace(content)
            }
            content
        }
    }
}
