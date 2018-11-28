package jp.co.chitose.sign;

import jp.co.chitose.DBSetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    public int createAccount(int accountId, String accountName, String password, String accountRoll) {
        int n = 0;
        String sql = "INSERT INTO account VALUES(?, ?, ?, ?)";
        final String URL = DBSetting.URL;
        final String USER = DBSetting.USER;
        final String PASSWORD = DBSetting.PASSWORD;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, accountId);
                stmt.setString(2, accountName);
                stmt.setString(3, password);
                stmt.setString(4, accountRoll);
                n = stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
