package DBInitialization;

import beans.Result;
import constants.Constants;

import java.sql.*;

public class DBInitialize {
    private Connection connection;

    public DBInitialize(Connection connection) {
        this.connection = connection;
    }

    public void delete() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(Constants.DELETE_LOGINS);
            statement.executeUpdate(Constants.DELETE_TESTS);
            statement.executeUpdate(Constants.DELETE_RESULTS);
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_TO_DELETE + e);
        }
    }

    public void createTables(Result result) {

        try (Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatementResults = connection.prepareStatement(Constants.INSERT_INTO_RESULTS);
            PreparedStatement preparedStatementLogins = connection.prepareStatement(Constants.INSERT_INTO_LOGINS);
            PreparedStatement preparedStatementTests = connection.prepareStatement(Constants.INSERT_INTO_TESTS);

            preparedStatementLogins.setString(Constants.FIRST_ELEMENT, result.getLogin());
            preparedStatementLogins.execute();
            int idLogin = 0;
            try (ResultSet resultSetLogin = statement.executeQuery(Constants.GET_ID_LOGIN)) {
                idLogin = getId(resultSetLogin);
            }

            preparedStatementTests.setString(Constants.FIRST_ELEMENT, result.getTest());
            preparedStatementTests.execute();
            int idTest = 0;
            try (ResultSet resultSetTest = statement.executeQuery(Constants.GET_ID_TEST)) {
                idTest = getId(resultSetTest);
            }

            preparedStatementResults.setInt(Constants.FIRST_ELEMENT, idLogin);
            preparedStatementResults.setInt(Constants.SECOND_ELEMENT, idTest);
            preparedStatementResults.setDate(Constants.THIRD_ELEMENT, result.getDate());
            preparedStatementResults.setInt(Constants.FOUR_ELEMENT, result.getMark());
            preparedStatementResults.execute();
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_TO_WRITE_DATA + e);
        }
    }

    private int getId(ResultSet resultSet) throws SQLException {
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }
}
