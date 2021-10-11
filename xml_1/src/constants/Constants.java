package constants;

import java.text.SimpleDateFormat;

public class Constants {
    public static String FILENAME = "src/results.xml";
    public static int NAME_IND = 0;
    public static int DATE_IND = 1;
    public static int MARK_IND = 2;
    public static String DELIMITER = ";";
    public static String POINT = ".";
    public static int DENOMINATOR_FOR_MARK = 10;
    public static SimpleDateFormat IN_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat OUT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static String ERROR_SAX_PARSER = "Error SAX parse";
    public static String ERROR_IO = "Error I/O stream";

}
