package de.timolia.howto.translate;

public class Translation {
    private final Language language;
    private final String key;
    private final String value;

    public Translation(Language language, String key, String value) {
        this.language = language;
        this.key = key;
        this.value = value;
    }

    public String replace(String text) {
        return text.replace(replacementKey(), getValue());
    }

    private String replacementKey() {
        return "%" + getKey() + "%";
    }

    public Language getLanguage() {
        return language;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LanguageString{" +
                "language=" + language +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
