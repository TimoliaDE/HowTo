package de.timolia.howto.conversion

import de.timolia.howto.Dapp
import de.timolia.howto.rank.Rank
import de.timolia.howto.rank.TeamlerRankChange
import de.timolia.howto.teamler.Sex
import de.timolia.howto.teamler.Teamler
import java.io.IOException
import java.text.ParseException

object InitialConversion {
    @Throws(IOException::class, ParseException::class)
    fun convert() {
        val teamlerRankChanges = JsonBuilder.getTeamlerRankChanges()
        val teamlers= teamlerRankChanges.map(TeamlerRankChange::uuid).sorted().distinct().map { uuid ->
            val rankHistory = LinkedHashMap<String, Rank>()
            teamlerRankChanges
                    .filter { teamlerRankChange -> teamlerRankChange.uuid == uuid }
                    .forEach {
                        if (rankHistory.isEmpty()) {
                            rankHistory["initial"] = it.rankFrom
                        }
                        rankHistory[it.getReadableDate()] = it.rankTo
                    }
            Teamler(uuid, Sex.undefined, null, null, null, rankHistory)
        }.toList()
        JsonBuilder.getTeamlerResponsibilities().forEach { responsibilities ->
            val teamler = teamlers.find { teamler1 -> teamler1.uuid == responsibilities.uuid } ?: Teamler (
                    uuid = responsibilities.uuid,
                    sex = Sex.undefined,
                    responsibilitiesMain = null,
                    responsibilitiesSecondary = null,
                    fields = null,
                    rankHistory = null
            )
            println("teamler: $teamler")
            if (responsibilities.hv != null) {
                println("responsibilities.getHv(): " + responsibilities.hv)
                teamler.responsibilitiesMain = responsibilities.hv.split(", ")
            }
            if (responsibilities.nv != null) {
                teamler.responsibilitiesSecondary = responsibilities.nv.split(", ")
            }
        }
        println(Dapp.gson.toJson(teamlers))
    }
}
