package de.timolia.howto

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import de.timolia.howto.conversion.InitialConversion
import de.timolia.howto.generator.FileWriter
import de.timolia.howto.generator.PageRankChange
import de.timolia.howto.generator.PageResponsibilities
import de.timolia.howto.generator.PageTeamMembers
import de.timolia.howto.teamler.Teamler
import de.timolia.howto.translate.Translate
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.Throws
import kotlin.jvm.JvmStatic

object Dapp {
    val translate: Translate = Translate()
    val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val path = Path.of("docs", "team")
        translate.loadDirectory(path.resolve("translate"))
        val json = Files.readString(path.resolve("teamler.json"), StandardCharsets.UTF_8)
        val teamlers = gson.fromJson(json, Array<Teamler>::class.java)
        val teamlerList = Arrays.asList(*teamlers)
        teamlerList.forEach { obj: Teamler -> obj.updateName() }
        val fileWriter = FileWriter(path, translate)
        fileWriter.writeFile("changes", PageRankChange.generate(teamlerList))
        fileWriter.writeFile("members", PageTeamMembers.generate(teamlerList))
        fileWriter.writeFile("responsibilities", PageResponsibilities.generate(teamlerList))
        if (args.size == 1 && args[0].equals("init", ignoreCase = true)) {
            InitialConversion.convert()
        }
    }
}
