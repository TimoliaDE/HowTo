package de.timolia.howto

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.timolia.howto.conversion.InitialConversion
import de.timolia.howto.generator.FileWriter
import de.timolia.howto.generator.PageRankChange
import de.timolia.howto.generator.PageResponsibilities
import de.timolia.howto.generator.PageTeamMembers
import de.timolia.howto.teamler.Teamler
import de.timolia.howto.translate.Translate
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.logging.Logger

object Dapp {
    val translate: Translate = Translate()
    val gson: Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    private val logger: Logger = Logger.getLogger(this::class.simpleName)

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val path = Path.of("docs", "team")
        translate.loadDirectory(path.resolve("translate"))
        val json = Files.readString(path.resolve("teamler.json"))
        val teamlers = gson.fromJson(json, Array<Teamler>::class.java)
        val teamlerList = listOf(*teamlers)
        logger.info("Update team member names...")
        teamlerList.forEach(Teamler::updateName)
        with(FileWriter(path, translate)) {
            logger.info("Generate team changes...")
            writeFile("changes", PageRankChange.generate(teamlerList))
            logger.info("Generate team page members...")
            writeFile("members", PageTeamMembers(teamlerList).generate())
            logger.info("Generate team responsibilities...")
            writeFile("responsibilities", PageResponsibilities.generate(teamlerList))
        }
        if(args.any { it.equals("init", ignoreCase = true) }) {
            InitialConversion.convert()
        }
    }
}
