package serviceClasses;

import beans.Result;
import constants.Constants;
import interfaces.ResultDao;

import java.sql.*;

public class ResultsLoader {
    public static void loadResults(ResultDao reader, Connection connection){
        try (PreparedStatement psInsertResults = connection.prepareStatement(Constants.INSERT_INTO_RESULTS);
             PreparedStatement psInsertLogins = connection.prepareStatement(Constants.INSERT_INTO_LOGINS);
             PreparedStatement psSelectLogins = connection.prepareStatement(Constants.SELECT_LOGINS);
             PreparedStatement psInsertTests = connection.prepareStatement(Constants.INSERT_INTO_TESTS);
             PreparedStatement psSelectTests = connection.prepareStatement(Constants.SELECT_TESTS)) {

            while(reader.hasResult()) {
                Result result = reader.nextResult();
                String login = result.getLogin();
                String test = result.getTest();

                int idLogin = getId(login, psInsertLogins, psSelectLogins);
                int idTest = getId(test, psInsertTests, psSelectTests);

                psInsertResults.setInt(Constants.FIRST_ELEMENT, idLogin);
                psInsertResults.setInt(Constants.SECOND_ELEMENT, idTest);
                psInsertResults.setDate(Constants.THIRD_ELEMENT, result.getDate());
                psInsertResults.setInt(Constants.FOUR_ELEMENT, result.getMark());
                psInsertResults.addBatch();
            }
            psInsertResults.executeBatch();
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_INITIALIZATION_DB + e);
        }
    }

     private static int getId(String name, PreparedStatement psInsert, PreparedStatement psSelect) throws SQLException {
        final int INDEX = 1;

        psSelect.setString(INDEX, name);

        try (ResultSet resultSet = psSelect.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(INDEX);
            } else {
                psInsert.setString(INDEX, name);
                psInsert.executeUpdate();

                try (ResultSet resultSet1 = psSelect.executeQuery()) {
                    resultSet1.next();
                    return resultSet1.getInt(INDEX);
                }
            }
        }
    }
}
