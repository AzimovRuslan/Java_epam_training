import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_CSV = "src/in.csv";
        try(Scanner sc = new Scanner(new FileReader(INPUT_CSV))) {
            Locale.setDefault(Locale.US);
            final String PLUS = " + ";
            final String MINUS = " - ";
            int error = 0;
            double sum = 0;
            StringBuilder sb = new StringBuilder();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split(";");

                try {
                    int i = Integer.parseInt(splitLine[0]);
                    sum += Double.parseDouble(splitLine[i]);

                    if (Double.parseDouble(splitLine[i]) < 0) {
                        sb.append(MINUS).append(splitLine[i].replace("-", ""));
                    } else {
                        sb.append(PLUS).append(splitLine[i]);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    error++;
                }
            }

            if (sb.length() > 0) {
                if (sb.charAt(1) == '-') {
                    sb.delete(0, 2);
                    sb.setCharAt(0, '-');
                } else {
                    sb.delete(0, 3);
                }
            }

            System.out.printf("result(%s) = %.2f%n", sb.toString(), sum);
            System.out.println("error-lines = " + error);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
