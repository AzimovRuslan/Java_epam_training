import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME))) {
            String linePurchase = "";
            String lineDay = "";
            Map<Purchase, WeekDay> map = new HashMap<>();

            while (sc.hasNextLine()) {
                map.put(PurchaseFactory.getPurchase(linePurchase), );
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

    }
}
