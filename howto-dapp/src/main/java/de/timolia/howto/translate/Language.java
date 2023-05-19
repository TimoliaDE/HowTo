package de.timolia.howto.translate;

import java.util.Locale;

public enum Language {
    DE,
    EN;

    public String key() {
        return name().toLowerCase(Locale.ROOT);
    }
}
