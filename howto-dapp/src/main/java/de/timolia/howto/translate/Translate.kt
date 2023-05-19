package de.timolia.howto.translate;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Translate {
    private final Map<Language, List<Translation>> translations = new HashMap<>();

    public void loadDirectory(Path path) throws IOException {
         Files.list(path).forEach(file -> {
              try {
                   mayLoadFile(file);
              } catch (IOException e) {
                   throw new UncheckedIOException("Failed to load translation from " + file, e);
              }
         });
    }

    private void mayLoadFile(Path path) throws IOException {
         String name = path.getFileName().toString();
         System.out.println(name);
         if (!name.endsWith(".properties")) {
              return;
         }
         String languageName = name.substring(0, name.length() - ".properties".length());
         Language language = Language.valueOf(languageName.toUpperCase(Locale.ROOT));
         System.out.println(languageName);
         Properties properties = new Properties();
         properties.load(Files.newBufferedReader(path, StandardCharsets.UTF_8));
         translations.put(language, properties.entrySet()
                 .stream()
                 .map(property -> new Translation(language, property.getKey().toString(), property.getValue().toString()))
                 .collect(Collectors.toList()));
    }
    
    public TranslationContext forLanguage(Language language) {
        List<Translation> translations = this.translations.get(language);
        if (translations == null) {
            throw new IllegalArgumentException("No translations for language " + language);
        }
        return content -> {
            for (Translation translation : translations) {
                content = translation.replace(content);
            }
            return content;
        };
    }
}
