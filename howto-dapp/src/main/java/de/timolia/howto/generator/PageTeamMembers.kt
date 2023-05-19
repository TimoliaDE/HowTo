package de.timolia.howto.generator

import de.timolia.howto.rank.Rank
import de.timolia.howto.teamler.Teamler
import java.util.*
import java.util.stream.Collectors

object PageTeamMembers {
    fun generate(teamlers: MutableList<Teamler>): String {
        var teamlers = teamlers
        teamlers = teamlers
                .filter { teamler -> teamler.getRankCurrent().inTeam }
                .sortedWith { obj, o -> obj.compare(o) }
                .toMutableList()
        val ranks = Arrays.stream(Rank.values()).filter { rank -> rank.description != null }.sorted { obj, o -> obj.compare(o) }.collect(Collectors.toList())
        val sb = StringBuilder()
        sb.append("%page.members.first-1%").append(teamlers.size).append("%page.members.first-2%\n")
        val rankStrings = ranks.map { rank -> "<span class='" + rank.cssClass + "'>" + rank.male + "</span>" }
        for (i in rankStrings.indices) {
            sb.append(rankStrings[i])
            if (i < rankStrings.size - 2) {
                sb.append(", ")
            } else if (i == rankStrings.size - 2) {
                sb.append(" %and% ")
            }
        }
        sb
                .append("%page.members.first-3%")
                .append("\n")
                .append("\n").append("%page.members.first-4%")
                .append("\n")
                .append("\n").append("![%page.members.first-5%](img/content-ranks.png)")
        for (rank in ranks) {
            sb
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n").append("## ").append(rank.male)
                    .append("\n")
                    .append("\n").append(rank.description)
                    .append("\n")
            for (teamler in teamlers.filter { teamler -> teamler.getRankCurrent() == rank }) {
                sb
                        .append("\n")
                        .append("\n")
                        .append("### <strong><span class='").append(rank.cssClass).append("'>").append(teamler.getNameForMarkdown()).append("</span></strong>")
                        .append("\n").append("- <u>%page.members.rank-ingame%:</u> ").append(rank.getString(teamler.sex))
                if (teamler.responsibilitiesMain != null) {
                    sb
                            .append("\n")
                            .append("- <u>%page.members.hv%:</u> ").append(teamler.responsibilitiesMain!!.stream().sorted { obj, str -> obj.compareTo(str, ignoreCase = true) }.collect(Collectors.joining(", ")))
                }
                if (teamler.responsibilitiesSecondary != null) {
                    sb
                            .append("\n")
                            .append("- <u>%page.members.nv%:</u> ").append(teamler.responsibilitiesSecondary!!.stream().sorted { obj, str -> obj.compareTo(str, ignoreCase = true) }.collect(Collectors.joining(", ")))
                }
                if (teamler.fields != null) {
                    sb
                            .append("\n")
                            .append("- <u>%page.members.fields%:</u> ").append(teamler.fields.stream().sorted { obj, str -> obj.compareTo(str, ignoreCase = true) }.collect(Collectors.joining(", ")))
                }
            }
        }
        sb.append("\n")
        return sb.toString()
    }
}
