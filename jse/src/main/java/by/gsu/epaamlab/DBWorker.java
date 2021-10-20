package by.gsu.epaamlab;

import beans.Result;
import constants.Constants;
import utils.ClassFactory;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DBWorker {
    private Connection connection;
    private String filename;

    public DBWorker(Connection connection, String filename) {
        this.connection = connection;
        this.filename = filename;
    }

    List<Result> resultList = new LinkedList<>();

    public List<Result> getResultList() {
        return resultList;
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
                    Result result = ClassFactory.getClassFromFactory(filename);
                    result.setIdResult(resultSet.getInt(Constants.FIRST_ELEMENT));
                    result.setLogin(resultSet.getString(Constants.SEVEN_ELEMENT));
                    result.setTest(resultSet.getString(Constants.NINE_ELEMENT));
                    result.setDate(resultSet.getDate(Constants.FOUR_ELEMENT));
                    result.setMark(resultSet.getInt(Constants.FIVE_ELEMENT));
                    resultList.add(result);
                }
            } catch (SQLException e) {
            System.err.println(Constants.FAILED_TO_INITIALIZATION_LIST + e);
        }
    }

    public <T> void printCollection(Collection<T> collection) {
        if (collection.size() > 0) {
            for(T result : collection) {
                System.out.println(result);
            }
        } else {
            System.out.println(Constants.EMPTY_COLLECTION);
        }
    }

    public void printTestsResultsInTheLastDay() {
        if (resultList.size() > 0) {
            java.sql.Date lastDay = resultList.get(resultList.size() - 1).getDate();
            for(Result result : resultList) {
                if (result.getDate().equals(lastDay)) {
                    System.out.println(Constants.TEST_RESULTS_IN_THE_LAST_DAY + result);
                }
            }
        } else {
            System.out.println(Constants.EMPTY_COLLECTION);
        }
    }
}
