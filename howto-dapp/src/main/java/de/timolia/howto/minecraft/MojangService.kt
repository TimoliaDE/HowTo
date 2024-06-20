package de.timolia.howto.minecraft

import com.google.gson.Gson
import fuel.httpGet
import kotlinx.coroutines.runBlocking
import java.util.logging.Logger

object MojangService {
    data class ProfileInfo(val id: String, val name: String? = null)
    private val resolved = HashMap<String, String>()
    private val logger = Logger.getLogger(this::class.simpleName)

    /**
     * Get the player name of an uuid from the Mojang api or local cache
     *
     * @param uuid the uuid of the player the name should be looked up
     * @param fallback the name of player if the Mojang api can't look up the player name
     * @return the player name
     */
    fun nameFromUUid(uuid: String, fallback: () -> String) = resolved.computeIfAbsent(uuid) {
        resolve(uuid) ?: fallback()
    }

    private fun resolve(uuid: String): String? = runBlocking {
        val baseUrl = "https://sessionserver.mojang.com/session/minecraft/profile/$uuid"

        val response = baseUrl.httpGet()
        try {
            Gson().fromJson(response.body, ProfileInfo::class.java).name!!
        } catch (exception: Exception) {
            logger.warning(response.body)
            null
        }
    }
}