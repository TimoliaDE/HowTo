package de.timolia.howto

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.timolia.howto.conversion.InitialConversion
import de.timolia.howto.generator.FileWriter
import de.timolia.howto.generator.PageRankChange
import de.timolia.howto.generator.PageResponsibilities
import de.timolia.howto.generator.PageTeamMembers
import de.timolia.howto.minecraft.MojangService
import de.timolia.howto.teamler.Teamler
import de.timolia.howto.translate.Translate
import kotlinx.coroutines.runBlocking
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.Throws
import kotlin.jvm.JvmStatic

object Dapp {
    val translate: Translate = Translate()
    val gson: Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val path = Path.of("docs", "team")
        translate.loadDirectory(path.resolve("translate"))
        val json = Files.readString(path.resolve("teamler.json"))
        val teamlers = gson.fromJson(json, Array<Teamler>::class.java)
        val teamlerList = listOf(*teamlers)
        teamlerList.forEach(Teamler::updateName)
        with(FileWriter(path, translate)) {
            writeFile("changes", PageRankChange.generate(teamlerList))
            writeFile("members", PageTeamMembers(teamlerList).generate())
            writeFile("responsibilities", PageResponsibilities.generate(teamlerList))
        }
        if(args.any { it.equals("init", ignoreCase = true) }) {
            InitialConversion.convert()
        }
    }
}
