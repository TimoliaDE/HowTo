package de.timolia.howto.teamler

import de.timolia.howto.database.SQLApi
import de.timolia.howto.rank.Rank
import de.timolia.howto.rank.TeamlerRankChange
import org.apache.commons.lang3.Validate
import java.text.ParseException
import java.text.RuleBasedCollator
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

class Teamler(
        val uuid: UUID,
        val sex: Sex,
        var responsibilitiesMain: MutableList<String>?,
        var responsibilitiesSecondary: MutableList<String>?,
        val fields: MutableList<String>?,
        private val rankHistory: LinkedHashMap<String, Rank>?
) {
    private var name: String
    private val responsibilitiesMainHidden: MutableList<String>? = null
    private val responsibilitiesSecondaryHidden: MutableList<String>? = null

    @Transient
    private var rankCurrent: Rank? = null

    init {
        name = SQLApi.getName(uuid)!!
    }

    fun getNameForMarkdown(): String {
        return name.replace("_", "\\\\_")
    }

    fun getRankChanges(includeHidden: Boolean): MutableList<TeamlerRankChange> {
        val rankChanges: MutableList<TeamlerRankChange> = ArrayList()
        if (rankHistory.isNullOrEmpty()) {
            return rankChanges
        }
        for (i in 0 until rankHistory.size) {
            val rank = rankHistory.values.toTypedArray()[i]
            Validate.notNull(rank, "Der " + (i + 1) + ". Rang von '" + name + "' existiert nicht")
        }
        val dates = rankHistory.keys
                .map { s -> s.replace("hidden-", "") }
                .map { date -> TeamlerRankChange.toDate(date) }
                .sorted()
        for (i in Math.min(1, dates.size - 1) until dates.size) {
            var hidden = false
            var rankOldKey: String = TeamlerRankChange.toString(dates[Math.max(i - 1, 0)])
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
            throw RuntimeException()
        }
    }

    fun hasResponsibilityMain(responsibility: String?): Boolean {
        return hasResponsibility(responsibility, Stream.concat(if (responsibilitiesMain == null) Stream.empty() else responsibilitiesMain!!.stream(), responsibilitiesMainHidden?.stream()
                ?: Stream.empty()).collect(Collectors.toList()))
    }

    fun hasResponsibilitySecondary(responsibility: String?): Boolean {
        return hasResponsibility(responsibility, Stream.concat(if (responsibilitiesSecondary == null) Stream.empty() else responsibilitiesSecondary!!.stream(), responsibilitiesSecondaryHidden?.stream()
                ?: Stream.empty()).collect(Collectors.toList()))
    }

    private fun hasResponsibility(responsibility: String?, responsibilityList: MutableList<String>?): Boolean {
        if (!getRankCurrent().inTeam && responsibilityList!!.isNotEmpty()) {
            throw RuntimeException("'$name' has responsibilities but is not in team anymore")
        }
        return responsibilityList != null && (responsibilityList.contains(responsibility) || responsibilityList.contains("$responsibility Forum"))
    }

    fun updateName() {
        name = SQLApi.getName(uuid, name)!!
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
