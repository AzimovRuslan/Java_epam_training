package DBInitialization;

import constants.Constants;
import exceptions.InitRuntimeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSingleton {
    private final static Connection CONNECTION = getInstance();

    private DBConnectSingleton(){ }

    private static Connection getInstance() {
        try {
            return DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
        } catch (SQLException e) {
            throw new InitRuntimeException(Constants.CONNECTION_ERROR);
        }
    }

    public static Connection getConnection() {
        return CONNECTION;
    }

    public static void closeConnection() {
        if(CONNECTION != null) {
            try {
                CONNECTION.close();
            } catch (SQLException e) {
                System.err.println(Constants.FAILED_CLOSE_CONNECTION);
            }
        }

    }
}
