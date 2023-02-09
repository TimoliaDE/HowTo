package de.timolia.howto.conversion;

import de.timolia.howto.Dapp;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SQLApi {

    private static Connection connection;
    private static final Map<String, UUID> usernames = new HashMap<>();
    private static final Map<UUID, String> uuids = new HashMap<>();

    private static void establishConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(Dapp.MYSQL_CON_STR, Dapp.MYSQL_USER, Dapp.MYSQL_PASS);
        }
    }


    public static UUID getUuid(String name) {
        if (usernames.containsKey(name)) {
            return usernames.get(name);
        }

        System.out.print("Fetching UUID of '" + name + "'... ");
        try {
            establishConnection();
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT uuid FROM timolia_user_names WHERE name=? ORDER BY last_played DESC LIMIT 1");
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();

            UUID uuid = UUID.fromString(resultSet.getString("uuid"));
            usernames.put(name, uuid);
            System.out.println("'" + uuid + "'");
            return uuid;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot find UUID of '" + name + "'");
        }
    }

    public static String getName(UUID uuid) {
        return getName(uuid, null);
    }

    public static String getName(UUID uuid, String fallback) {
        if (uuids.containsKey(uuid)) {
            return uuids.get(uuid);
        }

        System.out.print("Fetching name of '" + uuid + "'... ");
        try {
            establishConnection();
            //PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM timolia_user_names WHERE uuid=? ORDER BY last_played DESC LIMIT 1");
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM timolia_user WHERE uuid=?");
            prepareStatement.setString(1, uuid.toString());
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            uuids.put(uuid, name);
            System.out.println(name);
            return name;
        } catch (SQLException e) {
            if (Dapp.isDevEnv && fallback != null) {
                System.err.println("Cannot find name of '" + uuid + "', using '" + fallback + "'");
                uuids.put(uuid, fallback);
                return fallback;
            }

            e.printStackTrace();
            throw new RuntimeException("Cannot find name of '" + uuid + "'");
        }
    }

}
