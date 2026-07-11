package xyz.agaev.nongrata.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    private final DatabaseManager databaseManager;

    public DatabaseInitializer(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void initialize() {

        try (Connection connection = databaseManager.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS records(
                        uuid TEXT PRIMARY KEY,
                        nickname TEXT NOT NULL,
                        category TEXT NOT NULL,
                        danger INTEGER NOT NULL,
                        reason TEXT NOT NULL,
                        author TEXT NOT NULL,
                        created_at INTEGER NOT NULL
                    );
                    """);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
