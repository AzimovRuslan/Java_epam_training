import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Frequence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            try (Connection connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD); Statement statement = connection.createStatement();
                 PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_INTO_FREQUENCIES);) {
                
                statement.executeUpdate(Constants.DELETE_FROM_FREQUENCIES);

                List<Frequence> frequencies = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery(Constants.SELECT_FROM_COORDINATES);) {
                    while (resultSet.next()) {
                        frequencies.add(new Frequence(resultSet.getInt(Constants.LEN_IND), resultSet.getInt(Constants.NUM_IND)));
                    }
                }

                for (Frequence frequence : frequencies) {
                    preparedStatement.setInt(Constants.LEN_IND, frequence.getLen());
                    preparedStatement.setInt(Constants.NUM_IND, frequence.getNum());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();

                try (ResultSet resultSet = statement.executeQuery(Constants.SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM);) {
                    while(resultSet.next()) {
                        System.out.println(resultSet.getInt(Constants.LEN_IND) + Constants.DELIMITER + resultSet.getInt(Constants.NUM_IND));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_LOAD_DRIVER);
        }
    }
}
