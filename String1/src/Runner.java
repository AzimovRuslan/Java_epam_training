import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final String INPUT_CSV = "src/in.csv";
        try(Scanner sc = new Scanner(new FileReader(INPUT_CSV))) {
            final String PLUS = "+";
            final String MINUS = "-";
            int error = 0;
            double sum = 0;
            ArrayList<Double> numbers = new ArrayList<>();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split(";");

                if (!isInteger(splitLine[0]) || Integer.parseInt(splitLine[0]) > splitLine.length || Integer.parseInt(splitLine[0]) < 0) {
                    error++;
                } else {
                    int i = Integer.parseInt(splitLine[0]);
                    if (!isDouble(splitLine[i])) {
                        splitLine[i] = splitLine[i].replace(splitLine[i], "0.0");
                        numbers.add(Double.parseDouble(splitLine[i]));
                        sum += Double.parseDouble(splitLine[i]);
                        error++;
                    } else {
                        numbers.add(Double.parseDouble(splitLine[i]));
                        sum += Double.parseDouble(splitLine[i]);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(numbers.get(0)).append(" ");
            for(int i = 1; i < numbers.size(); i++) {
                String temp;
                if (numbers.get(i) < 0) {
                    temp = MINUS + " " + Math.abs(numbers.get(i));
                } else {
                    temp = PLUS + " " + numbers.get(i);
                }
                sb.append(temp).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);

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
