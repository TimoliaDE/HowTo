package de.timolia.howto.models;

public class LanguageString {

    private final Language language;
    private final String key;
    private final String value;

    public LanguageString(Language language, String key, String value) {
        this.language = language;
        this.key = key;
        this.value = value;
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
