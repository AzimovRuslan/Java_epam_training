import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            ResourceBundle rb = ResourceBundle.getBundle("text");
            Enumeration<String> keys = rb.getKeys();
            final String KEY_REG_EXP = "^index(.*)";
            final String NUM_REG_EXP = "[1-9]\\d*";
            
            Pattern keyPattern = Pattern.compile(KEY_REG_EXP);
            Pattern valuePattern = Pattern.compile(NUM_REG_EXP);

            final int TAIL_INDEX = 1;
            final String VALUE = "value";
            final String SUM = "sum = ";
            final String ERROR_LINES = "error-lines = ";
            String key;
            String iStr;
            String jStr;
            String valueIJ;
            double sum = 0;
            int error = 0;

            while (keys.hasMoreElements()) {
                key = keys.nextElement();
                Matcher keyMatcher = keyPattern.matcher(key);

                if (keyMatcher.matches()) {
                    iStr = keyMatcher.group(TAIL_INDEX).trim();
                    jStr = rb.getString(key).trim();
                    Matcher iMatcher = valuePattern.matcher(iStr);
                    Matcher jMatcher = valuePattern.matcher(jStr);

                    if (iMatcher.matches() && jMatcher.matches()) {
                        valueIJ = VALUE + iStr + jStr;
                        try {
                            sum += Double.parseDouble(rb.getString(valueIJ).trim());
                        } catch (NumberFormatException | MissingResourceException e) {
                            error++;
                        }
                    } else {
                        error++;
                    }

                }
            }
            System.out.println(SUM + sum);
            System.out.println(ERROR_LINES + error);
        } catch (MissingResourceException e) {
            System.out.println("No input file");
        }
    }
}