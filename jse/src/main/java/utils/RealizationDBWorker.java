package utils;

import by.gsu.epaamlab.DBWorker;

import java.sql.Connection;

public class RealizationDBWorker {
    private Connection connection;
    private String filename;

    public RealizationDBWorker(Connection connection, String filename) {
        this.connection = connection;
        this.filename = filename;
    }

    public void realization(){
        DBWorker dbWorker = new DBWorker(connection, filename);
        dbWorker.getMeanMark();
        dbWorker.initializationListOrderByDate();
        dbWorker.printCollection(dbWorker.getResultList());
        dbWorker.printTestsResultsInTheLastDay();
    }
}
