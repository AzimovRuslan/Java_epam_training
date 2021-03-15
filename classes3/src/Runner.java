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

            showArray(purchases);

            double meanCost = 0;
            int totalCostMonday = 0;
            int maxCost = 0;
            int sum = 0;
            Purchase maxPurchase = new Purchase();

            for(Purchase purchase : purchases){
                sum += purchase.getCost();

                if(purchase.getWeekDay() == WeekDay.values()[1]){
                    totalCostMonday += purchase.getCost();
                }

                if(purchase.getCost() > maxCost){
                    maxCost = purchase.getCost();
                    maxPurchase = purchase;
                }
            }

            meanCost = sum * 100.0 / purchases.length / 10000;
            System.out.printf("mean coast = %.3f rubles%n", meanCost);
            System.out.println("total cost monday = " + Utilities.convertMoney(totalCostMonday));
            System.out.println("purchase with max cost = " + maxPurchase);

            Arrays.sort(purchases);
            showArray(purchases);

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

    private static void showArray(Purchase[] purchases){
        System.out.println(Purchase.PRODUCT_NAME + "\n" + Utilities.convertMoney(Purchase.PRICE_BOOK));
        for(Purchase purchase : purchases){
            System.out.println(purchase);
        }
    }

}
