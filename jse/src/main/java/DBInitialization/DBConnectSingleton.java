package DBInitialization;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSingleton {
    private static Connection CONNECTION = getConnection();

    public DBConnectSingleton(){ }

    public static Connection getCONNECTION() {
        if (CONNECTION == null) {
            CONNECTION = getCONNECTION();
        }
        return CONNECTION;
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(Constants.CONNECTION_ERROR);
        }
    }

    public static void closeConnection() {
        try {
            if (CONNECTION != null) {
                CONNECTION.close();
            }
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_CLOSE_CONNECTION + e);
        }
    }
}
