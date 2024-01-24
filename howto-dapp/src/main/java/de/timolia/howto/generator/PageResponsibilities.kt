package de.timolia.howto.generator

import de.timolia.howto.Dapp
import de.timolia.howto.teamler.Teamler
import de.timolia.howto.responsibility.Responsibility
import de.timolia.howto.responsibility.ResponsibilityType
import de.timolia.howto.translate.Language
import java.util.*

object PageResponsibilities {
    fun generate(teamlers: List<Teamler>): String {
        val responsibilities: LinkedHashMap<String, LinkedHashMap<String, String?>> = object : LinkedHashMap<String, LinkedHashMap<String, String?>>() {
            init {
                put("%page.responsibilities.project-team-orga%", object : LinkedHashMap<String, String?>() {
                    init {
                        put("%page.responsibilities.teamleader%", "%page.responsibilities.teamleader.desc%")
                        put("%page.responsibilities.project-team-orga.apply.builder%", null)
                        put("%page.responsibilities.project-team-orga.apply.development%", null)
                        put("%page.responsibilities.project-team-orga.apply.support%", "%page.responsibilities.project-team-orga.apply.support.desc%")
                        put("%page.responsibilities.project-team-orga.howto%", "%page.responsibilities.project-team-orga.howto.desc%")
                        put("%page.responsibilities.project-team-orga.tournament%", "%page.responsibilities.project-team-orga.tournament.desc%")
                        //put("%page.responsibilities.project-team-orga.uhc%", "%page.responsibilities.project-team-orga.uhc.desc%");
                        put("%page.responsibilities.project-team-orga.youtuber%", "%page.responsibilities.project-team-orga.youtuber.desc%")
                    }
                })
                put("%page.responsibilities.communication-platforms%", object : LinkedHashMap<String, String?>() {
                    init {
                        put("%page.responsibilities.communication-platforms.community-discord%", "%page.responsibilities.communication-platforms.community-discord.desc%")
                        //put("%page.responsibilities.communication-platforms.bug-reports%", null);
                        put("%page.responsibilities.communication-platforms.appeal%", null)
                        put("%page.responsibilities.communication-platforms.falsely-banned%", null)
                        put("%page.responsibilities.communication-platforms.socialmedia%", "%page.responsibilities.communication-platforms.socialmedia.desc%")
                        put("%page.responsibilities.communication-platforms.teamspeak%", "%page.responsibilities.communication-platforms.teamspeak.desc%")
                    }
                })
                put("%page.responsibilities.other-responsibilities%", object : LinkedHashMap<String, String?>() {
                    init {
                        put("%page.responsibilities.other-responsibilities.graphicdesign%", null)
                        put("%page.responsibilities.other-responsibilities.map-submissions%", null)
                        put("%page.responsibilities.other-responsibilities.monthly-winner%", null)
                        //put("%page.responsibilities.other-responsibilities.translation%", null);
                    }
                })
            }
        }
        val sb = StringBuilder()
        sb.append("%page.responsibilities.info%")
        for ((categoryName, subcategories) in responsibilities) {
            sb
                    .append("\n")
                    .append("\n").append("# ").append(categoryName)
            val nameConverter = Dapp.translate.forLanguage(Language.DE)
            for (e in subcategories.entries) {
                val name = nameConverter.replaceAll(e.key)
                val description = e.value
                sb.append("\n").append("\n").append("### **").append(name).append("**")
                if (description != null) {
                    sb.append("\n").append(description).append("\n")
                }
                val hv = teamlers
                        .filter { teamler -> teamler.hasResponsibilityMain(name) }
                        .sortedWith { obj, o -> obj.compare(o) }
                val nv = teamlers
                        .filter { teamler -> teamler.hasResponsibilitySecondary(name) }
                        .sortedWith { obj, o -> obj.compare(o) }
                var titleCustom: String? = null
                val hvCustom = LinkedList<Responsibility>()
                val nvCustom = LinkedList<Responsibility>()
                when (e.key) {
                    "%page.responsibilities.bug-reports%" -> nvCustom.add(Responsibility.simple(ResponsibilityType.NV, "%page.responsibilities.custom.bug-reports.modsanddevs%"))
                    "%page.responsibilities.sm%" -> {
                        titleCustom = "Projekte u. Verantwortungsgrad"
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Twitter") }.sortedWith { obj, o -> obj.compare(o) }) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter.hv%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilitySecondary("Twitter") }.sortedWith { obj, o -> obj.compare(o) }) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter.nv%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Bauteam-Twitter") }.sortedWith { obj, o -> obj.compare(o) }) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter-builder.hv%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilitySecondary("Bauteam-Twitter") }.sortedWith { obj, o -> obj.compare(o) }) {
                            nvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.sm.twitter-builder.nv%"))
                        }
                    }

                    "%page.responsibilities.teamleader%" -> {
                        titleCustom = "%page.responsibilities.custom.teamleader.title%"
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Management des Timolia-Teams") }.sortedWith { obj, o -> obj.compare(o) }) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.whole-team%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Management des Bau-Teams") }.sortedWith { obj, o -> obj.compare(o) }) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.builder%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Management des Content-Teams") }.sortedWith { obj, o -> obj.compare(o) }) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.content%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Management des Development-Teams") }.sortedWith { obj, o -> obj.compare(o) }) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.development%"))
                        }
                        for (teamler in teamlers.filter { teamler -> teamler.hasResponsibilityMain("Management des Support-Teams") }.sortedWith { obj, o -> obj.compare(o) }) {
                            hvCustom.add(Responsibility.concreteTeamster(teamler, "%page.responsibilities.custom.teamleader.support%"))
                        }
                    }

                    "%page.responsibilities.yter%" -> titleCustom = "%page.responsibilities.custom.yter.title%"
                }
                if (titleCustom == null) {
                    sb.append("\n").append("| %page.responsibilities.teamler% | %page.responsibilities.responsib% |")
                } else {
                    sb.append("\n").append("| %page.responsibilities.teamler% | ").append(titleCustom).append(" |")
                }
                sb.append("\n").append("| ------ | ------ |")
                if (hvCustom.isEmpty()) {
                    for (teamler in hv) {
                        hvCustom.add(Responsibility.concreteTeamster(ResponsibilityType.HV, teamler))
                    }
                }
                for (hvEntry in hvCustom) {
                    sb.append("\n")
                    hvEntry.renderTo(sb)
                }
                if (nvCustom.isEmpty()) {
                    for (teamler in nv) {
                        nvCustom.add(Responsibility.concreteTeamster(ResponsibilityType.NV, teamler))
                    }
                }
                for (nvEntry in nvCustom) {
                    sb.append("\n")
                    println(nvEntry)
                    nvEntry.renderTo(sb)
                }
            }
        }
        sb.append("\n")
        return sb.toString()
    }
}
