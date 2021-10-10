package constants;

import java.text.SimpleDateFormat;

public class Constants {
    public static String FILENAME = "src/results.xml";
    public static int NAME_IND = 0;
    public static int DATE_IND = 1;
    public static int MARK_IND = 2;
    public static String DELIMITER = ";";
    public static String POINT = ".";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String OUT_DATE_FORMAT = "dd.MM.yyyy";
    public static int DENOMINATOR_FOR_MARK = 10;
    public static SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT);
    public static SimpleDateFormat SET_DATE_FORMAT = new SimpleDateFormat(Constants.OUT_DATE_FORMAT);
    public static String ERROR_SAX_PARSER = "Error SAX parse";
    public static String ERROR_IO = "Error I/O stream";

}
