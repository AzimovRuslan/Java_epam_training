import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Frequence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            PreparedStatement preparedStatement = null;
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(Constants.SELECT_FROM_COORDINATES);

                List<Frequence> frequencies = new ArrayList<>();

                while (resultSet.next()) {
                    int len = resultSet.getInt(1);
                    int num = resultSet.getInt(2);
                    frequencies.add(new Frequence(len, num));
                }

                preparedStatement = connection.prepareStatement(Constants.DELETE_FROM_FREQUENCIES);
                preparedStatement.execute();

                for (Frequence frequence : frequencies) {
                    preparedStatement = connection.prepareStatement(Constants.INSERT_INTO_FREQUENCIES);
                    preparedStatement.setInt(Constants.FIRST_ELEMENT, frequence.getLen());
                    preparedStatement.setInt(Constants.SECOND_ELEMENT, frequence.getNum());
                    preparedStatement.execute();
                }

                ResultSet resultSetFrequencies = statement.executeQuery(Constants.SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM);
                while(resultSetFrequencies.next()) {
                    System.out.println(resultSetFrequencies.getInt(Constants.FIRST_ELEMENT) + Constants.DELIMITER + resultSetFrequencies.getInt(Constants.SECOND_ELEMENT));
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
            }
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_LOAD_DRIVER);
        }
    }
}
