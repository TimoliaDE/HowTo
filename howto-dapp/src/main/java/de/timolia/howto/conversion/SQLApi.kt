package de.timolia.howto.conversion

import java.sql.SQLException
import java.util.*
import kotlin.jvm.Volatile

object SQLApi {
    @Volatile
    private var connection: SqlUserConnection? = null

    @Volatile
    private var triedConnect = false

    private fun establishConnection(): SqlUserConnection {
        if (!triedConnect) {
            synchronized(SQLApi::class.java) {
                if (!triedConnect) {
                    tryGuardedConnect()
                }
            }
        }
        return connection ?: throw RuntimeException("Earlier attempt connecting to sql failed")
    }

    private fun tryGuardedConnect() {
        try {
            connection = SqlUserConnection.connect()
        } catch (exception: SQLException) {
            throw RuntimeException("Unable to establish sql connection", exception)
        } finally {
            triedConnect = true
        }
    }

    fun getUuid(name: String?): UUID? {
        return try {
            establishConnection().getUuid(name)
        } catch (exception: RuntimeException) {
            exception.printStackTrace()
            throw exception
        }
    }

    fun getName(uuid: UUID?): String? {
        return getName(uuid, null)
    }

    fun getName(uuid: UUID?, fallback: String?): String? {
        val connection: SqlUserConnection = try {
            establishConnection()
        } catch (exception: RuntimeException) {
            if (fallback != null && SqlUserConnection.isDevEnv()) {
                System.err.println("Unable to establish sql connection for $uuid fallback to $fallback")
                exception.printStackTrace()
                return fallback
            }
            throw RuntimeException("Unable to establish sql connection", exception)
        }
        return connection.getName(uuid, fallback)
    }
}
