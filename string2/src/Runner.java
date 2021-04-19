import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            ResourceBundle rb = ResourceBundle.getBundle("text");
            Enumeration<String> keys = rb.getKeys();
            String key;
            double sum = 0;
            int error = 0;

            Pattern indexPattern = Pattern.compile("^index(.*)");
            Pattern numberPattern = Pattern.compile("[1-9]\\d*");

            while (keys.hasMoreElements()) {
                key = keys.nextElement();
                String j = rb.getString(key).trim();
                Matcher indexMatcher = indexPattern.matcher(key);
                if (indexMatcher.matches()) {
                    String i = indexMatcher.group(1).trim();
                    if (numberPattern.matcher(i).matches() && numberPattern.matcher(j).matches()) {
                        String value = "value" + i + j;
                        try {
                            sum += Double.parseDouble(rb.getString(value).trim());
                        } catch (NumberFormatException | MissingResourceException e) {
                            error++;
                        }
                    } else {
                        error++;
                    }
                }
            }
            System.out.println("sum = " + sum);
            System.out.println("error-lines = " + error);
        } catch (MissingResourceException e) {
            System.out.println("File not found");
        }
    }
}