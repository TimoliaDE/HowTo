package de.timolia.howto.minecraft

import com.google.gson.Gson
import fuel.httpGet
import kotlinx.coroutines.runBlocking

object MojangService {
    data class ProfileInfo(val id: String, val name: String? = null)
    val resolved = HashMap<String, String>()

    fun nameFromUUid(uuid: String) = resolved.computeIfAbsent(uuid, ::resolve)

    fun resolve(uuid: String): String = runBlocking {
        val base_url = "https://sessionserver.mojang.com/session/minecraft/profile/$uuid"

        val response = base_url.httpGet()
        try {
            Gson().fromJson(response.body, ProfileInfo::class.java).name!!
        } catch (exception: Exception) {
            println(response)
            throw exception
        }
    }
}