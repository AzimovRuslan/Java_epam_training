import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Frequence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String dbUrl = Constants.URL;
        String user = Constants.USER;
        String password = Constants.PASSWORD;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            PreparedStatement preparedStatement = null;
            Connection connection;
            try {
                connection = DriverManager.getConnection(dbUrl, user, password);
                Statement statement = connection.createStatement();
                ResultSet resSetCoords = statement.executeQuery(Constants.SELECT_FROM_COORDINATES);

                deleteFrequencies(preparedStatement, connection);

                while (resSetCoords.next()) {
                    int lenSegment = Math.round(Math.abs(resSetCoords.getFloat(2) - resSetCoords.getFloat(1)));
                    int numSegment = 1;
                    insertFrequencies(preparedStatement, connection, Constants.INSERT_INTO_FREQUENCIES, lenSegment, numSegment);
                }

                ResultSet resSetFreq = statement.executeQuery(Constants.GROUP_BY_FOR_FREQUENCIES);

                List<Frequence> list = new ArrayList<>();

                while (resSetFreq.next()) {
                    list.add(new Frequence(resSetFreq.getInt(1), resSetFreq.getInt(2)));
                }

                deleteFrequencies(preparedStatement, connection);

                for (Frequence frequence : list) {
                    insertFrequencies(preparedStatement, connection, Constants.INSERT_INTO_FREQUENCIES, frequence.getLen(), frequence.getNum());
                }

                ResultSet resSetFreq1 = statement.executeQuery(Constants.SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM);

                while(resSetFreq1.next()) {
                    System.out.println(resSetFreq1.getInt(1) + Constants.DELIMITER + resSetFreq1.getInt(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвер");
        }
    }

    private static void insertFrequencies(PreparedStatement preparedStatement, Connection connection, String query, int len, int num) {
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, len);
            preparedStatement.setInt(2, num);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFrequencies(PreparedStatement preparedStatement, Connection connection) {
        try {
            preparedStatement = connection.prepareStatement(Constants.DELETE_FROM_FREQUENCIES);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
