import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_CSV = "src/in.csv";
        try(Scanner sc = new Scanner(new FileReader(INPUT_CSV))) {
            Locale.setDefault(Locale.US);
            final String PLUS = "+";
            final String MINUS = "-";
            int error = 0;
            double sum = 0;
            StringBuilder sb = new StringBuilder();


            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split(";");

                if (!isInteger(splitLine[0]) || Integer.parseInt(splitLine[0]) > splitLine.length || Integer.parseInt(splitLine[0]) < 0) {
                    error++;
                } else {
                    int i = Integer.parseInt(splitLine[0]);
                    if (!isDouble(splitLine[i])) {
                        splitLine[i] = splitLine[i].replace(splitLine[i], "0.0");
                        sb.append(Double.parseDouble(splitLine[i])).append(" ");
                        sum += Double.parseDouble(splitLine[i]);
                        error++;
                    } else {
                        if (Double.parseDouble(splitLine[i]) < 0) {
                            sum += Double.parseDouble(splitLine[i]);
                            splitLine[i] = splitLine[i].replace("-", " ");
                            sb.append(MINUS).append(" ").append(Double.parseDouble(splitLine[i])).append(" ");
                        } else {
                            sum += Double.parseDouble(splitLine[i]);
                            sb.append(PLUS).append(" ").append(Double.parseDouble(splitLine[i])).append(" ");
                        }
                    }
                }
            }

            if (sb.charAt(0) == '-') {
                sb.deleteCharAt(0);
                sb.setCharAt(0, '-');
            } else {
                sb.deleteCharAt(0);
                sb.deleteCharAt(0);
            }
//            if (sb.charAt(0) == '-') {
//                sb.delete(0, 1);
//                sb.deleteCharAt(0);
//            }

            sb.deleteCharAt(sb.length() - 1);
//            for(int i = 6; i < sb.length(); i++){
//                if (i == sb.indexOf("-")) {
//                    System.out.println(sb.indexOf("-"));
//                }
//            }

            System.out.printf("result(%s) = %.2f%n", sb.toString(), sum);
            System.out.println("error-lines = " + error);
        }catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(String.valueOf(s));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(String.valueOf(s));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
