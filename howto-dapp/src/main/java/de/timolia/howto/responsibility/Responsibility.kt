package de.timolia.howto.responsibility

import de.timolia.howto.teamler.Teamler

fun interface Responsibility {
    fun renderTo(builder: StringBuilder)

    companion object {
        fun simple(type: ResponsibilityType, teamler: String): Responsibility {
            return Responsibility { builder ->
                builder
                        .append("|")
                        .append(teamler)
                        .append(" | ")
                        .append(type.defaultKey())
                        .append(" |")
            }
        }

        fun concreteTeamster(type: ResponsibilityType, teamler: Teamler): Responsibility {
            return concreteTeamster(teamler, type.defaultKey())
        }

        fun concreteTeamster(teamler: Teamler, translationKey: String): Responsibility {
            return Responsibility { builder ->
                builder
                        .append("|<span class='")
                        .append(teamler.getRankCurrent().cssClass)
                        .append("'>")
                        .append(teamler.getNameForMarkdown())
                        .append("</span>")
                        .append(" | ")
                        .append(translationKey)
                        .append(" |")
            }
        }
    }
}
