package by.gsu.epaamlab;

import DBInitialization.DBConnectSingleton;
import beans.Result;
import constants.Constants;
import exceptions.LoadRuntimeException;
import exceptions.SourceException;
import factories.ResultFactory;
import interfaces.ResultDao;
import serviceClasses.ResultsLoader;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;

public class RunnerLogic {

    private static final Connection connection = DBConnectSingleton.getConnection();

    public static void execute(String filename, ResultFactory factory){
        try {
            loader(filename, factory);
            printAverageMark();
            getCurrentAndPrintLastDay(factory);
        } finally {
            DBConnectSingleton.closeConnection();
        }
    }

    private static void loader(String filename, ResultFactory factory) {
        try(ResultDao reader = factory.getResultImplFromFactory(filename)) {
                ResultsLoader.loadResults(reader, connection);
            } catch (ConnectException e) {
                throw new LoadRuntimeException(Constants.ERROR_DB_LOAD);
            } catch (IOException e) {
                System.err.println(Constants.ERROR_IO + e);
            } catch (SourceException e) {
                System.err.println(Constants.ERROR_OPEN_SOURCE);
        }
    }

    private static void printAverageMark() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.GET_MEAN_MARK)) {
            while (resultSet.next()) {
                String login = resultSet.getString(Constants.FIRST_ELEMENT);
                String mark = resultSet.getString(Constants.SECOND_ELEMENT);
                System.out.printf("%s%s%s\n", login, Constants.DELIMITER, mark);
            }
        } catch (SQLException e) {
            System.err.println(Constants.CANT_GET_MEAN_MARK + e);
        }
    }

    private static void getCurrentAndPrintLastDay(ResultFactory factory) {
        try {
            List<Result> currentMonthResults = getCurrentMonthResults(factory);
            printLastDayResults(currentMonthResults);
        } catch (SQLException e) {
            System.err.println(Constants.CANT_GET_MEAN_MARK + " " + e.getMessage());
        }
    }

    private static List<Result> getCurrentMonthResults(ResultFactory factory) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.GET_TESTS_RESULTS_FOR_THE_CURRENT_MONTH)) {
            List<Result> currentMonthResults = new LinkedList<>();

            while (resultSet.next()) {
                Result result = factory.getResultFromFactory(resultSet.getString(Constants.SEVEN_ELEMENT), resultSet.getString(Constants.NINE_ELEMENT), resultSet.getDate(Constants.FOUR_ELEMENT), resultSet.getInt(Constants.FIVE_ELEMENT));
                System.out.println(result);
                currentMonthResults.add(result);
            }
            return currentMonthResults;
        }
    }

    private static void printLastDayResults(List<Result> results) {
        if (results.size() > 0) {
            ListIterator<Result> iterator = results.listIterator(results.size());
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
