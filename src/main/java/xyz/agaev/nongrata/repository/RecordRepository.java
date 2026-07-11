package xyz.agaev.nongrata.repository;

import xyz.agaev.nongrata.database.DatabaseManager;
import xyz.agaev.nongrata.model.PlayerRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecordRepository {

    private final DatabaseManager databaseManager;

    public RecordRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void save(PlayerRecord record) throws Exception {

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                     INSERT OR REPLACE INTO records
                     (uuid,nickname,category,danger,reason,author,created_at)
                     VALUES(?,?,?,?,?,?,?)
                     """)) {

            statement.setString(1, record.getUuid().toString());
            statement.setString(2, record.getNickname());
            statement.setString(3, record.getCategory());
            statement.setInt(4, record.getDanger());
            statement.setString(5, record.getReason());
            statement.setString(6, record.getAuthor());
            statement.setLong(7, record.getCreatedAt());

            statement.executeUpdate();
        }
    }

    public List<PlayerRecord> findAll() throws Exception {

        List<PlayerRecord> list = new ArrayList<>();

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM records");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                PlayerRecord record = new PlayerRecord();

                record.setUuid(java.util.UUID.fromString(rs.getString("uuid")));
                record.setNickname(rs.getString("nickname"));
                record.setCategory(rs.getString("category"));
                record.setDanger(rs.getInt("danger"));
                record.setReason(rs.getString("reason"));
                record.setAuthor(rs.getString("author"));
                record.setCreatedAt(rs.getLong("created_at"));

                list.add(record);
            }
        }

        return list;
    }

}
