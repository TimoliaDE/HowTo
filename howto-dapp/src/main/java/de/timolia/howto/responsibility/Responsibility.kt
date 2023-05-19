package de.timolia.howto.responsibility;

import de.timolia.howto.models.Teamler;

public interface Responsibility {
    void renderTo(StringBuilder builder);

    static Responsibility simple(ResponsibilityType type, String teamler) {
        return builder -> builder
                .append("|")
                .append(teamler)
                .append(" | ")
                .append(type.defaultKey())
                .append(" |");
    }

    static Responsibility concreteTeamster(ResponsibilityType type, Teamler teamler) {
        return concreteTeamster(teamler, type.defaultKey());
    }

    static Responsibility concreteTeamster(Teamler teamler, String translationKey) {
        return builder -> builder
                .append("|<span class='")
                .append(teamler.getRankCurrent().getCssClass())
                .append("'>")
                .append(teamler.getNameForMarkdown())
                .append("</span>")
                .append(" | ")
                .append(translationKey)
                .append(" |");
    }
}
