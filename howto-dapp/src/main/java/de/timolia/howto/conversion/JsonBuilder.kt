package de.timolia.howto.conversion

import de.timolia.howto.rank.TeamlerRankChange
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.text.ParseException
import java.util.*
import java.util.regex.Pattern
import kotlin.Throws

object JsonBuilder {
    @Throws(IOException::class, ParseException::class)
    fun getTeamlerRankChanges(): List<TeamlerRankChange> {
        var content = Files.readString(Path.of("src/main/resources", "changes.md"))
        content = Pattern.compile("^([^|]|\\| ------|\\| Spieler).*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n")
        content = Pattern.compile("[ \t]*\\|[ \t]*", Pattern.MULTILINE).matcher(content).replaceAll("|")
        content = Pattern.compile("</span>", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("<span class='[\\w-]+'>", Pattern.MULTILINE).matcher(content).replaceAll("")
        return content.split("\n").reversed().filter(String::isNotEmpty).map {
            var (_, name, rankFrom, rankTo, date) = it.split("|")
            name = name.replace("\\", "")
            val teamlerRankChange = TeamlerRankChange(name, rankFrom, rankTo, date)
            println(teamlerRankChange)
            teamlerRankChange
        }
    }

    @Throws(IOException::class)
    fun getTeamlerResponsibilities(): Iterable<TeamlerResponsibilities> {
        var content = Files.readString(Path.of("src/main/resources", "members.md"))
        content = Pattern.compile("^(?!-|###).*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("^- <u>Rang \\(ingame\\):.*$", Pattern.MULTILINE).matcher(content).replaceAll("")
        content = Pattern.compile("(\r\n)+", Pattern.MULTILINE).matcher(content).replaceAll("\n")
        return content.split("###")
                .filter { it.contains("Hauptverantwortlich") || it.contains("Nebenverantwortlich") }
                .map {s ->
                    var s = s
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
                    TeamlerResponsibilities(name, hv, nv)
                }
    }
}
