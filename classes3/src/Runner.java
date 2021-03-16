import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.Utilities;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))){
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            for(int i = 0; i < PURCHASES_NUMBER; i++){
                int number = sc.nextInt();
                double percent = sc.nextDouble();
                int day = sc.nextInt();
                purchases[i] = new Purchase(number, percent, WeekDay.values()[day]);
            }

            printPurchases(purchases);

            double meanCost = 0;
            int totalCostMonday = 0;
            int maxCost = 0;
            int totalCost = 0;
            Purchase maxPurchase = new Purchase();

            for(Purchase purchase : purchases){
                totalCost += purchase.getCost();

                if(purchase.getDay() == WeekDay.values()[1]){
                    totalCostMonday += purchase.getCost();
                }

                if(purchase.getCost() > maxCost){
                    maxCost = purchase.getCost();
                    maxPurchase = purchase;
                }
            }

            if(purchases.length > 0)
                meanCost = totalCost * 100.0 / purchases.length / 10000;

            System.out.printf("mean coast = %.3f rubles%n", meanCost);
            System.out.println("total cost monday = " + Utilities.convertMoney(totalCostMonday));
            System.out.println("purchase with max cost = " + maxPurchase);

            Arrays.sort(purchases);
            printPurchases(purchases);

            Purchase purchase = new Purchase(5, 0, WeekDay.values()[0]);

            int retPurchase = Arrays.binarySearch(purchases, purchase);

            if(retPurchase < 0){
                System.out.println("purchase is not found");
            }
            else{
                System.out.println("purchase wih number equalled to 5 = " + purchases[retPurchase]);
            }
        }catch (FileNotFoundException e){
            System.err.println("Input file is not found");
        }
    }

    private static void printPurchases(Purchase[] purchases){
        System.out.println(Purchase.PRODUCT_NAME + "\n" + Utilities.convertMoney(Purchase.PRICE_BOOK));
        for(Purchase purchase : purchases){
            System.out.println(purchase);
        }
    }

}
