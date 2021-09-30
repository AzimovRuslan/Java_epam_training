package by.gsu.epamlab;

public class Constants {
    public static String DELIMITER = ";";
    public static String URL = "jdbc:mysql://localhost:3306/segments";
    public static String USER = "root";
    public static String PASSWORD = "Ruslan4ik2001";
    public static String SELECT_FROM_COORDINATES = "SELECT * FROM coordinates";
    public static String INSERT_INTO_FREQUENCIES = "INSERT INTO frequencies VALUES (?, ?)";
    public static String DELETE_FROM_FREQUENCIES = "delete from frequencies";
    public static String SELECT_FROM_FREQUENCIES_WHERE_LEN_MORE_NUM = "SELECT * FROM frequencies WHERE len>num";
    public static String GROUP_BY_FOR_FREQUENCIES = "select len, sum(num) as num from frequencies group by len";
    public static int FIRST_ELEMENT = 1;
    public static int SECOND_ELEMENT = 2;

}
