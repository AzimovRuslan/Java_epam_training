package by.gsu.epamlab;

public class Utilities {
    public static String convertMeanCost(int meanCost){
        return String.format("%d.%03d rubles", meanCost / 100, meanCost % 100);
    }

    public static String convertMoney(int cost){
        return String.format("%d.%02d rubles", cost / 100, cost % 100);
    }
}
