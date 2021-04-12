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
            int errorLines = 0;
            double sum = 0;
            StringBuilder strResult = new StringBuilder();

            while(scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(DELIMITER);

                try {
                    int i = Integer.parseInt(words[0]);
                    sum += Double.parseDouble(words[i]);

                    if (Double.parseDouble(words[i]) < 0) {
                        strResult.append(MINUS).append(Math.abs(Double.parseDouble(words[i])));
                    } else {
                        strResult.append(PLUS).append(words[i]);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    errorLines++;
                }
            }

            if (strResult.length() > 0) {
                final int SIGN_LENGTH = MINUS.length();
                final char CHAR_MINUS = '-';
                if (strResult.charAt(1) == CHAR_MINUS){
                    strResult.delete(0, SIGN_LENGTH - 1);
                    strResult.setCharAt(0, CHAR_MINUS);
                } else {
                    strResult.delete(0, SIGN_LENGTH);
                }
            }

            System.out.println(RESULT_HEAD + strResult.toString() + RESULT_TAIL + sum);
            System.out.println(ERROR_LINES + errorLines);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
