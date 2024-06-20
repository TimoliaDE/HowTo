package de.timolia.howto.teamler

import de.timolia.howto.conversion.SQLApi
import de.timolia.howto.minecraft.MojangService
import de.timolia.howto.rank.Rank
import de.timolia.howto.rank.TeamlerRankChange
import org.apache.commons.lang3.Validate
import java.text.ParseException
import java.text.RuleBasedCollator
import java.util.*

class Teamler(
        val uuid: UUID,
        val sex: Sex,
        var responsibilitiesMain: List<String>?,
        var responsibilitiesSecondary: List<String>?,
        val fields: List<String>?,
        private val rankHistory: LinkedHashMap<String, Rank>?
) {
    private var name: String = "Unresolved"
    private val responsibilitiesMainHidden: List<String>? = null
    private val responsibilitiesSecondaryHidden: List<String>? = null

    @Transient
    private var rankCurrent: Rank? = null

    fun getNameForMarkdown() = name.replace("_", "\\_")

    fun getRankChanges(includeHidden: Boolean): MutableList<TeamlerRankChange> {
        val rankChanges = mutableListOf<TeamlerRankChange>()
        if (rankHistory.isNullOrEmpty()) {
            return rankChanges
        }
        val ranks = rankHistory.values.toTypedArray()
        ranks.forEachIndexed { index, rank ->
            Validate.notNull(rank, "Der " + (index + 1) + ". Rang von '" + name + "' existiert nicht")
        }
        val dates = rankHistory.keys
                .map { s -> s.replace("hidden-", "") }
                .map { date -> TeamlerRankChange.toDate(date) }
                .sorted()
        for (i in 1.coerceAtMost(dates.size - 1) until dates.size) {
            var hidden = false
            var rankOldKey: String = TeamlerRankChange.toString(dates[(i - 1).coerceAtLeast(0)])
            if (!rankHistory.containsKey(rankOldKey) && rankHistory.containsKey("hidden-$rankOldKey")) {
                rankOldKey = "hidden-$rankOldKey"
            }
            val rankOld = rankHistory[rankOldKey]
            var rankNewKey: String = TeamlerRankChange.toString(dates[i])
            if (!rankHistory.containsKey(rankNewKey) && rankHistory.containsKey("hidden-$rankNewKey")) {
                rankNewKey = "hidden-$rankNewKey"
                hidden = true
            }
            val rankNew = rankHistory[rankNewKey]
            if (includeHidden || !hidden && rankNewKey != "initial") {
                val teamlerRankChange = TeamlerRankChange(name, uuid, rankOld!!, rankNew!!, TeamlerRankChange.toString(dates[i]), hidden)
                rankChanges.add(teamlerRankChange)
            }
        }
        return rankChanges
    }

    fun getRankCurrent(): Rank {
        if (rankCurrent == null) {
            val teamlerRankChanges = getRankChanges(true)
            val lastRankChange = teamlerRankChanges[teamlerRankChanges.size - 1]
            rankCurrent = lastRankChange.rankTo
        }
        return rankCurrent!!
    }

    fun compare(o: Teamler): Int {
        if (getRankCurrent() != o.getRankCurrent()) {
            // compare by rank
            return getRankCurrent().compare(o.getRankCurrent())
        }

        // compare by name
        val rules = "< '_'"
        return try {
            val ruleBasedCollator = RuleBasedCollator(rules)
            ruleBasedCollator.compare(name.lowercase(Locale.getDefault()), o.name.lowercase(Locale.getDefault()))
        } catch (e: ParseException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    fun hasResponsibilityMain(responsibility: String?): Boolean {
        return hasResponsibility(
                responsibility,
                (responsibilitiesMain ?: emptyList()) + (responsibilitiesMainHidden ?: emptyList())
        )
    }

    fun hasResponsibilitySecondary(responsibility: String?): Boolean {
        return hasResponsibility(
                responsibility,
                (responsibilitiesSecondary ?: emptyList()) + (responsibilitiesSecondaryHidden ?: emptyList())
        )
    }

    private fun hasResponsibility(responsibility: String?, responsibilityList: List<String>): Boolean {
        if (!getRankCurrent().inTeam && responsibilityList.isNotEmpty()) {
            throw RuntimeException("'$name' has responsibilities but is not in team anymore")
        }
        return responsibilityList.contains(responsibility) || responsibilityList.contains("$responsibility Forum")
    }

    fun updateName() {
        name = MojangService.nameFromUUid(uuid.toString()) {
            SQLApi.getName(uuid).toString()
        }
    }

    override fun toString(): String {
        return "Teamler{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", sex=" + sex +
                ", responsibilitiesMain=" + responsibilitiesMain +
                ", responsibilitiesSecondary=" + responsibilitiesSecondary +
                ", rankHistory=" + rankHistory +
                '}'
    }
}
