package by.gsu.epaamlab;

import DBInitialization.DBConnectSingleton;
import beans.Result;
import constants.Constants;
import factories.ResultFactory;
import interfaces.ResultDao;
import serviceClasses.ResultsLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;

public class RunnerLogic {
    private String filename;
    private ResultFactory factory;
    private final Connection connection = DBConnectSingleton.getCONNECTION();

    public RunnerLogic(String filename, ResultFactory factory) {
        this.filename = filename;
        this.factory = factory;
    }

    private List<Result> resultList = new LinkedList<>();

    public void execute(){
        try {
            loader();
            getMeanMark();
            initializationListOrderByDate();
            printResults(resultList);
            printTestsResultsInTheLastDay();
        } finally {
            DBConnectSingleton.closeConnection();
        }
    }

    private void loader() {
        try(ResultDao reader = factory.getResultImplFromFactory(filename)) {
                ResultsLoader.loadResults(reader, connection);
            } catch (IOException e) {
                System.err.println(Constants.ERROR_IO + e);
            }
    }

    public void getMeanMark() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.GET_MEAN_MARK)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(Constants.FIRST_ELEMENT) + Constants.SPACE + resultSet.getString(Constants.SECOND_ELEMENT));
            }
        } catch (SQLException e) {
            System.err.println(Constants.CANT_GET_MEAN_MARK + e);
        }
    }

    public void initializationListOrderByDate() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.GET_TESTS_RESULTS_FOR_THE_CURRENT_MONTH)) {
            while (resultSet.next()) {
                Result result = factory.getResultFromFactory(resultSet.getString(Constants.SEVEN_ELEMENT), resultSet.getString(Constants.NINE_ELEMENT), resultSet.getDate(Constants.FOUR_ELEMENT), resultSet.getInt(Constants.FIVE_ELEMENT));
                resultList.add(result);
            }
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_TO_INITIALIZATION_LIST + e);
        }
    }

    public void printResults(List<Result> results) {
        if (results.size() > 0) {
            for(Result result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println(Constants.EMPTY_COLLECTION);
        }
    }

    public void printTestsResultsInTheLastDay() {
        if (resultList.size() > 0) {
            ListIterator<Result> iterator = resultList.listIterator(resultList.size());
            Result result = iterator.previous();
            Date lastDate = result.getDate();
            System.out.println(Constants.TEST_RESULTS_IN_THE_LAST_DAY);
            System.out.println(result);

            while (iterator.hasPrevious()) {
                result = iterator.previous();
                if (!lastDate.equals(result.getDate())) {
                    break;
                }
                System.out.println(result);
            }
        } else {
            System.out.println(Constants.EMPTY_COLLECTION);
        }
    }
}
