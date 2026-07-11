package xyz.agaev.nongrata.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final File databaseFile;

    public DatabaseManager(File dataFolder) {

        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        databaseFile = new File(dataFolder, "database.db");

    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:sqlite:" + databaseFile.getAbsolutePath()
        );

    }

}
