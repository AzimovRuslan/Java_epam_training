package constants;

import java.text.SimpleDateFormat;

public class Constants {
    public static String URL = "jdbc:mysql://localhost:3306/results";
    public static String USER = "jse";
    public static String PASSWORD = "jse";
    public static String FILENAME_XML = "src/main/java/results.xml";
    public static String FILENAME_CSV = "src/main/java/results.csv";
    public static String FILENAME_CSV2 = "src/main/java/results2.csv";

    public static SimpleDateFormat IN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static int FIRST_ELEMENT = 1;
    public static int SECOND_ELEMENT = 2;
    public static int THIRD_ELEMENT = 3;
    public static int FOUR_ELEMENT = 4;
    public static int FIVE_ELEMENT = 5;
    public static int SEVEN_ELEMENT = 7;
    public static int NINE_ELEMENT = 9;
    public static int FIRST_INDEX = 0;
    public static int SECOND_INDEX = 1;
    public static int THIRD_INDEX = 2;
    public static int FOUR_INDEX = 3;
    public static int NAME_IND = 0;
    public static int DATE_IND = 1;
    public static int MARK_IND = 2;

    public static String EMPTY_COLLECTION = "empty collection";
    public static String TEST_RESULTS_IN_THE_LAST_DAY = "test result in the last day => ";
    public static String DELIMITER = ";";
    public static String POINT = ".";
    public static String SPACE = " ";
    public static int DENOMINATOR_FOR_MARK = 10;
    public static String FORMAT_FOR_MARK = "%d.%01d";

    public static String ERROR_IO = "Error I/O stream =>";
    public static String CONNECTION_ERROR = "Connection error =>";
    public static String CANT_GET_MEAN_MARK = "cant get mean mark =>";
    public static String FAILED_INITIALIZATION_DB = "failed initialization database =>";
    public static String FAILED_CLOSE_CONNECTION = "failed close connection =>";
    public static String ERROR_PARSE_DATE = "failed to parse date =>";
    public static String WRONG_DATA_XML = "wrong data in xml =>";
    public static String ERROR_DB_LOAD = "error db load =>";
    public static String ERROR_OPEN_SOURCE = "error open source =>";

    public static String INSERT_INTO_LOGINS = "INSERT INTO logins (name) VALUES (?)";
    public static String SELECT_LOGINS = "SELECT * FROM logins WHERE name = ?";
    public static String INSERT_INTO_TESTS = "INSERT INTO tests (name) VALUES (?)";
    public static String SELECT_TESTS = "SELECT * FROM tests WHERE name = ?";
    public static String INSERT_INTO_RESULTS = "INSERT INTO results (loginId, testId, date, mark) VALUES (?, ?, ?, ?)";
    public static String GET_MEAN_MARK = "select logins.name, round(avg(mark / 10), 2) as meanMark from results join logins on logins.idLogin = results.loginId group by logins.name order by meanMark desc";
    public static String GET_TESTS_RESULTS_FOR_THE_CURRENT_MONTH = "select * from results join logins on logins.idLogin = results.loginId join tests on tests.idTest = results.testId where month(date) = month(now()) order by date";
}
