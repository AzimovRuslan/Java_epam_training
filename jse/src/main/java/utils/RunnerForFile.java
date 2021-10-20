package utils;

import DBInitialization.DBConnect;
import DBInitialization.DBInitializationFromFile;
import DBInitialization.DBInitialize;
import constants.Constants;

import java.sql.Connection;
import java.sql.SQLException;

public class RunnerForFile {
    public static void run(String filename){
        try (Connection connection = DBConnect.getCONNECTION()) {
            DBInitializationFromFile dbInitializationFromFile = new DBInitializationFromFile();
            dbInitializationFromFile.dbInitialization(filename, new DBInitialize(connection));

            RealizationDBWorker realizationDBWorker = new RealizationDBWorker(connection, filename);
            realizationDBWorker.realization();
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_INITIALIZATION_DB + e);
        }
    }
}
