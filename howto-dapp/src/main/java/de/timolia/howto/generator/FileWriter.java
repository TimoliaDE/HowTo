package de.timolia.howto.generator;

import de.timolia.howto.translate.Language;
import de.timolia.howto.translate.Translate;
import de.timolia.howto.translate.TranslationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    private final Translate translate;
    private final Path path;

    public FileWriter(Path path, Translate translate) {
        this.path = path;
        this.translate = translate;
    }

    public void writeFile(String name, String text) throws IOException {
        for (Language language : Language.values()) {
            TranslationContext translation = translate.forLanguage(language);
            String fileName = name + "." + language.key() + ".md";
            String content = translation.replaceAll(text);
            writeFile(path.resolve(fileName), content);
        }
    }

    private static void writeFile(Path path, String text) throws IOException {
        path.toFile().getParentFile().mkdirs();
        Files.writeString(path, text, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        System.out.println("Wrote file '" + path + "'");
    }
}
