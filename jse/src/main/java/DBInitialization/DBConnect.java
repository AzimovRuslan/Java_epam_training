package DBInitialization;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private final static Connection CONNECTION = getConnection();

    public DBConnect(){ }

    public static Connection getCONNECTION() {
        return CONNECTION;
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(Constants.CONNECTION_ERROR);
        }
    }
}
