package de.timolia.howto.conversion

import de.timolia.howto.Dapp
import de.timolia.howto.rank.Rank
import de.timolia.howto.teamler.Sex
import de.timolia.howto.teamler.Teamler
import java.io.IOException
import java.text.ParseException

object InitialConversion {
    @Throws(IOException::class, ParseException::class)
    fun convert() {
        val teamlers: MutableList<Teamler> = ArrayList()
        val teamlerRankChanges = JsonBuilder.getTeamlerRankChanges()
        teamlerRankChanges.map { obj -> obj.uuid }.sorted().distinct().forEach { uuid ->
            val rankHistory = LinkedHashMap<String, Rank>()
            teamlerRankChanges
                    .filter { teamlerRankChange -> teamlerRankChange.uuid == uuid }
                    .forEach {
                        if (rankHistory.isEmpty()) {
                            rankHistory["initial"] = it.rankFrom
                        }
                        rankHistory[it.getReadableDate()] = it.rankTo
                    }
            val teamler = Teamler(uuid, Sex.undefined, null, null, null, rankHistory)
            teamlers.add(teamler)
        }
        val teamlerResponsibilitiesList = JsonBuilder.getTeamlerResponsibilities()
        teamlerResponsibilitiesList.forEach { teamlerResponsibilities ->
            val teamler = teamlers.stream()
                    .filter { teamler1 -> teamler1.uuid == teamlerResponsibilities.uuid }
                    .findFirst()
                    .orElseGet { Teamler(teamlerResponsibilities.uuid, Sex.undefined, null, null, null, null) }
            println("teamler: $teamler")
            if (teamlerResponsibilities.hv != null) {
                println("teamlerResponsibilities.getHv(): " + teamlerResponsibilities.hv)
                teamler.responsibilitiesMain = mutableListOf(*teamlerResponsibilities.hv.split(", ").toTypedArray())
            }
            if (teamlerResponsibilities.nv != null) {
                teamler.responsibilitiesSecondary = mutableListOf(*teamlerResponsibilities.nv.split(", ").toTypedArray())
            }
        }
        println(Dapp.gson.toJson(teamlers))
    }
}
