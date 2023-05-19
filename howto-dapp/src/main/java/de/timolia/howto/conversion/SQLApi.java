package de.timolia.howto.conversion;

import de.timolia.howto.Dapp;

import java.sql.*;
import java.util.UUID;

public class SQLApi {
    private static volatile SqlUserConnection connection;
    private static volatile boolean triedConnect;

    private static SqlUserConnection establishConnection() {
        if (!triedConnect) {
            synchronized (SQLApi.class) {
                if (!triedConnect) {
                    tryGuardedConnect();
                }
            }
        }
        SqlUserConnection connection = SQLApi.connection;
        if (connection == null) {
            throw new RuntimeException("Earlier attempt connecting to sql failed");
        }
        return connection;
    }

    private static void tryGuardedConnect() {
        try {
            connection = SqlUserConnection.connect();
        } catch (SQLException exception) {
            throw new RuntimeException("Unable to establish sql connection", exception);
        } finally {
            triedConnect = true;
        }
    }

    public static UUID getUuid(String name) {
        try {
            return establishConnection().getUuid(name);
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public static String getName(UUID uuid) {
        return getName(uuid, null);
    }

    public static String getName(UUID uuid, String fallback) {
        SqlUserConnection connection;
        try {
            connection = establishConnection();
        } catch (RuntimeException exception) {
            if (fallback != null && SqlUserConnection.isDevEnv()) {
                System.err.println("Unable to establish sql connection for " + uuid + " fallback to " + fallback);
                exception.printStackTrace();
                return fallback;
            }
            throw new RuntimeException("Unable to establish sql connection", exception);
        }
        return connection.getName(uuid, fallback);
    }
}
