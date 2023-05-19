package de.timolia.howto.generator

import de.timolia.howto.rank.TeamlerRankChange
import de.timolia.howto.teamler.Sex
import de.timolia.howto.teamler.Teamler
import java.util.*

object PageRankChange {
    fun generate(teamlers: MutableList<Teamler>): String {
        val rankChanges = ArrayList<TeamlerRankChange>()
        for (teamler in teamlers) {
            rankChanges.addAll(teamler.getRankChanges(false))
        }
        rankChanges.sortWith { t1, t2 ->
            if (t1.date != t2.date) {
                return@sortWith t2.date.compareTo(t1.date)
            }
            if (t1.rankTo != t2.rankTo) {
                val teamler1 = teamlers.firstOrNull { t -> t.uuid == t1.uuid }
                val teamler2 = teamlers.firstOrNull { t -> t.uuid == t2.uuid }
                return@sortWith t1.rankTo.getString(teamler1?.sex ?: Sex.undefined).compareTo(t2.rankTo.getString(teamler2?.sex ?: Sex.undefined), ignoreCase = true)
            }
            t1.name.compareTo(t2.name, ignoreCase = true)
        }
        val sb = StringBuilder()
        sb
                .append("%page.rank-change.first%")
                .append("\n")
                .append("\n")
        var lastYear: String? = ""
        var lastMonth: String? = ""
        for (teamlerRankChange in rankChanges) {
            val teamler = teamlers.firstOrNull { t -> t.uuid == teamlerRankChange.uuid }
            val cal = Calendar.getInstance()
            cal.time = teamlerRankChange.date
            val month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN) + " " + cal[Calendar.YEAR]
            val year = cal[Calendar.YEAR].toString()
            if (year != lastYear) {
                lastYear = year
                sb.append("\n").append("\n").append("# ").append(year).append("\n")
            }
            if (month != lastMonth) {
                lastMonth = month
                sb.append("\n")
                sb.append("###  <strong>").append(month).append("</strong>").append("\n")
                sb.append("| %player% | %page.rank-change.rank-previous% | %page.rank-change.rank-new% | %date% |").append("\n")
                sb.append("| ------ | ------ | ------ | ------ |").append("\n")
            }
            sb
                    .append("| ")
                    .append(teamlerRankChange.getNameForMarkdown())
                    .append(" | ")
                    .append("<span class='").append(teamlerRankChange.rankFrom.cssClass).append("'>").append(teamlerRankChange.rankFrom.getString(teamler?.sex ?: Sex.undefined)).append("</span>")
                    .append(" | ")
                    .append("<span class='").append(teamlerRankChange.rankTo.cssClass).append("'>").append(teamlerRankChange.rankTo.getString(teamler?.sex ?: Sex.undefined)).append("</span>")
                    .append(" | ")
                    .append(teamlerRankChange.getReadableDate())
                    .append(" |")
                    .append("\n")
        }
        sb.append("\n")
        return sb.toString()
    }
}
