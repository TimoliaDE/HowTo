package de.timolia.howto.responsibility;

import java.util.Locale;

public enum ResponsibilityType {
    HV,
    NV;

    public String defaultKey() {
        return "%page.responsibilities." + name().toLowerCase(Locale.ROOT) + "%";
    }
}
