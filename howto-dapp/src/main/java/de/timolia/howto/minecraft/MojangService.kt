package de.timolia.howto.minecraft

import com.google.gson.Gson
import fuel.httpGet
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.logging.Logger
import kotlin.time.Duration

object MojangService {
    data class ProfileInfo(val id: String, val name: String? = null)
    private val resolved = HashMap<String, String>()
    private var requests = 0

    /**
     * set the rate-limit to 200 to take previous runs into consideration and the update it to 599 if the limit was
     * reached
     */
    private var rateLimit = 200
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
        if(requests > rateLimit) {
            logger.warning("Mojang Api Rate Limit reached! Suspending requests for 10 minutes!")
            delay(1000 * 60 * 10)   //wait 10 minutes until rate limit goes away
            rateLimit = 599
            requests = 0
        }
        val baseUrl = "https://sessionserver.mojang.com/session/minecraft/profile/$uuid"

        val response = baseUrl.httpGet()
        try {
            Gson().fromJson(response.body, ProfileInfo::class.java).name!!.also {
                requests ++
            }
        } catch (exception: Exception) {
            println(response)
            null
        }
    }
}