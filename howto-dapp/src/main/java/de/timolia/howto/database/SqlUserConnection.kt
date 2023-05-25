package de.timolia.howto.database

import java.sql.*
import java.util.*

class SqlUserConnection private constructor(private val connection: Connection) {
    private val usernames: MutableMap<String?, UUID?> = HashMap()
    private val uuids: MutableMap<UUID?, String?> = HashMap()

    fun getUuid(name: String?): UUID? {
        return usernames.computeIfAbsent(name, ::resolveUniqueId)
    }

    private fun resolveUniqueId(name: String?): UUID {
        return try {
            val prepareStatement = connection.prepareStatement("SELECT uuid FROM timolia_user_names WHERE name=? ORDER BY last_played DESC LIMIT 1")
            prepareStatement.setString(1, name)
            val resultSet = prepareStatement.executeQuery()
            if (!resultSet.next()) {
                throw RuntimeException("Cannot find UUID of '$name'")
            }
            UUID.fromString(resultSet.getString("uuid"))
        } catch (exception: SQLException) {
            throw RuntimeException("Failed to fetch uuid for name=$name'", exception)
        }
    }

    fun getName(uuid: UUID?, fallback: String?): String? {
        return uuids.computeIfAbsent(uuid) { uniqueId: UUID? -> resolveName(uniqueId, fallback) }
    }

    private fun resolveName(uuid: UUID?, fallback: String?): String? {
        try {
            val prepareStatement = connection.prepareStatement("SELECT * FROM timolia_user WHERE uuid=?")
            prepareStatement.setString(1, uuid.toString())
            val resultSet = prepareStatement.executeQuery()
            if (resultSet.next()) {
                return resultSet.getString("name")
            }
            if (fallback != null) {
                println("No name for uuid $uuid falling back to $fallback")
                return fallback
            }
            throw RuntimeException("Cannot find name of '$uuid'")
        } catch (exception: SQLException) {
            throw RuntimeException("Failed to fetch uuid for uuid=$uuid'", exception)
        }
    }

    companion object {
        @Throws(SQLException::class)
        fun connect(): SqlUserConnection {
            val environmentSuffix = if (isDevEnv()) "DEV" else "LIVE"
            val user = System.getenv("MYSQL_USER_$environmentSuffix")
            val password = System.getenv("MYSQL_PASS_$environmentSuffix")
            val connectionString = System.getenv("MYSQL_CON_STR_$environmentSuffix")
            val connection = DriverManager.getConnection(connectionString, user, password)
            return SqlUserConnection(connection)
        }

        fun isDevEnv(): Boolean {
            return System.getenv("MYSQL_USER_LIVE") == null
        }
    }
}
