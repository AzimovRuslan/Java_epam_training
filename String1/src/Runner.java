import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_CSV = "src/in.csv";
        try(Scanner scanner = new Scanner(new FileReader(INPUT_CSV))) {
            Locale.setDefault(Locale.US);
            final String BEFORE_SIGN = " ";
            final String AFTER_SIGN = " ";
            final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
            final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
            final String DELIMITER = ";";
            final String RESULT_HEAD = "result(";
            final String RESULT_TAIL = ") = ";
            final String ERROR_LINES = "error-lines = ";
            final char CHAR_MINUS = '-';
            final int MINUS_POS = MINUS.indexOf(CHAR_MINUS);
            int errorLines = 0;
            double sum = 0;
            StringBuilder strResult = new StringBuilder();

            while(scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(DELIMITER);

                try {
                    int i = Integer.parseInt(words[0]);
                    double number = Double.parseDouble(words[i]);
                    sum += number;

                    strResult.append(number < 0 ? MINUS : PLUS).append(Math.abs(number));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    errorLines++;
                }
            }

            if (strResult.length() > 0) {
                final int MINUS_LENGTH = MINUS.length();
                char c = strResult.charAt(MINUS_POS);
                strResult.delete(0, MINUS_LENGTH);
                if (c == CHAR_MINUS) {
                    strResult.insert(0, CHAR_MINUS);
                }
            }

            System.out.println(RESULT_HEAD + strResult.toString() + RESULT_TAIL + sum);
            System.out.println(ERROR_LINES + errorLines);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
