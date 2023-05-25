package de.timolia.howto.generator

import de.timolia.howto.rank.Rank
import de.timolia.howto.teamler.Teamler
import java.util.*
import java.util.stream.Collectors

class PageTeamMembers(
        private val teamlers: List<Teamler>,
        val sb: StringBuilder = StringBuilder()
) {
    fun generate(): String {
        val teamlers = teamlers
                .filter { teamler -> teamler.getRankCurrent().inTeam }
                .sortedWith(Teamler::compare)
                .toMutableList()
        val ranks = Rank.values().filter { rank -> rank.description != null }.sortedWith(Rank::compare).toList()
        sb.append("%page.members.first-1%").append(teamlers.size).append("%page.members.first-2%\n")
        val rankStrings = ranks.map { rank -> "<span class='${rank.cssClass}'>${rank.male}</span>" }
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
                teamler.responsibilitiesMain?.let {
                    appendStringList("page.members.hv", it)
                }
                teamler.responsibilitiesSecondary?.let {
                    appendStringList("page.members.nv", it)
                }
                teamler.fields?.let {
                    appendStringList("page.members.fields", it)
                }
            }
        }
        sb.append("\n")
        return sb.toString()
    }

    private fun appendStringList(name: String, strings: List<String>) {
        sb.append("\n").append("- <u>%${name}%:</u> ")
        strings.sortedWith { obj, str -> obj.compareTo(str, ignoreCase = true) }.joinTo(sb)
    }
}
