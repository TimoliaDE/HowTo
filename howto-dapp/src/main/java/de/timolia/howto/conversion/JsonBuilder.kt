package de.timolia.howto.conversion

import de.timolia.howto.rank.TeamlerRankChange
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.text.ParseException
import java.util.*
import java.util.regex.Pattern
import kotlin.Throws

object JsonBuilder {
    @Throws(IOException::class, ParseException::class)
    fun getTeamlerRankChanges(): MutableList<TeamlerRankChange> {
        var content = Files.readString(Path.of("src/main/resources", "changes.md"), StandardCharsets.UTF_8)
        content = Pattern.compile("^([^|]|\\| ------|\\| Spieler).*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n")
        content = Pattern.compile("[ \t]*\\|[ \t]*", Pattern.MULTILINE).matcher(content).replaceAll("|")
        content = Pattern.compile("</span>", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("<span class='[\\w-]+'>", Pattern.MULTILINE).matcher(content).replaceAll("")
        val teamlerRankChanges: MutableList<TeamlerRankChange> = ArrayList()
        val lines: Array<String?> = content.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (i in lines.indices.reversed()) {
            val line = lines[i]!!
            if (line.isEmpty()) {
                continue
            }
            val split: List<String> = line.split("|")
            val name: String = split[1].replace("\\", "")
            val rankFrom = split[2]
            val rankTo = split[3]
            val date = split[4]
            val teamlerRankChange = TeamlerRankChange(name, rankFrom, rankTo, date)
            teamlerRankChanges.add(teamlerRankChange)
            println(teamlerRankChange)
        }
        return teamlerRankChanges
    }

    @Throws(IOException::class)
    fun getTeamlerResponsibilities(): MutableList<TeamlerResponsibilities> {
        var content = Files.readString(Path.of("src/main/resources", "members.md"), StandardCharsets.UTF_8)
        content = Pattern.compile("^(?!-|###).*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("^- <u>Rang \\(ingame\\):.*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n")
        val teamlerResponsibilitiesList = ArrayList<TeamlerResponsibilities>()
        for (s in content.split("###")) {
            var s = s
            if (s.isEmpty() || !s.contains("Hauptverantwortlich") && !s.contains("Nebenverantwortlich")) continue
            s = s.substring(s.indexOf("'") + 1)
            s = s.substring(s.indexOf("'") + 2)
            val name: String = s.substring(0, s.indexOf("<")).replace("\\\\_".toRegex(), "_")
            var hv: String? = null
            var nv: String? = null
            s = s.substring(s.indexOf("-"))
            if (s.contains("Hauptverantwortlich")) {
                hv = s.substring(s.indexOf("Hauptverantwortlich") + "Hauptverantwortlich".length + 6, s.indexOf("\n"))
                s = s.substring(s.indexOf("Hauptverantwortlich") + "Hauptverantwortlich\n".length + 6 + hv.length)
            }
            if (s.contains("Nebenverantwortlich")) {
                nv = s.substring(s.indexOf("Nebenverantwortlich") + "Nebenverantwortlich".length + 6, s.indexOf("\n"))
            }
            println("name: $name")
            println("hv:   $hv")
            println("nv:   $nv")
            val teamlerResponsibilities = TeamlerResponsibilities(name, hv, nv)
            teamlerResponsibilitiesList.add(teamlerResponsibilities)
        }
        return teamlerResponsibilitiesList
    }
}
