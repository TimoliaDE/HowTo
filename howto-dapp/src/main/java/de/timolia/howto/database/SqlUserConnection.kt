package de.timolia.howto.conversion;

import de.timolia.howto.Dapp;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SqlUserConnection {
    public static SqlUserConnection connect() throws SQLException {
        String environmentSuffix = isDevEnv() ? "DEV" : "LIVE";
        String user = System.getenv("MYSQL_USER_" + environmentSuffix);
        String password = System.getenv("MYSQL_PASS_" + environmentSuffix);
        String connectionString = System.getenv("MYSQL_CON_STR_" + environmentSuffix);
        Connection connection = DriverManager.getConnection(connectionString, user, password);
        return new SqlUserConnection(connection);
    }

    public static boolean isDevEnv() {
        return System.getenv("MYSQL_USER_LIVE") == null;
    }

    private final Connection connection;
    private final Map<String, UUID> usernames = new HashMap<>();
    private final Map<UUID, String> uuids = new HashMap<>();

    private SqlUserConnection(Connection connection) {
        this.connection = connection;
    }

    public UUID getUuid(String name) {
        return usernames.computeIfAbsent(name, this::resolveUniqueId);
    }

    public UUID resolveUniqueId(String name) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT uuid FROM timolia_user_names WHERE name=? ORDER BY last_played DESC LIMIT 1");
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Cannot find UUID of '" + name + "'");
            }
            return UUID.fromString(resultSet.getString("uuid"));
        } catch (SQLException exception) {
            throw new RuntimeException("Failed to fetch uuid for name=" + name + "'", exception);
        }
    }

    public String getName(UUID uuid, String fallback) {
        return uuids.computeIfAbsent(uuid, uniqueId -> resolveName(uniqueId, fallback));
    }

    private String resolveName(UUID uuid, String fallback) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM timolia_user WHERE uuid=?");
            prepareStatement.setString(1, uuid.toString());
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
            if (fallback != null) {
                System.out.println("No name for uuid " + uuid + " falling back to " + fallback);
                return fallback;
            }
            throw new RuntimeException("Cannot find name of '" + uuid + "'");
        } catch (SQLException exception) {
            throw new RuntimeException("Failed to fetch uuid for uuid=" + uuid + "'", exception);
        }
    }
}
