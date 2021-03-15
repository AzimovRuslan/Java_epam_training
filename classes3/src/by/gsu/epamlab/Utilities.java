package by.gsu.epamlab;

public class Utilities {
    public static String convertMoney(int cost){
        return String.format("%d.%02d rubles", cost / 100, cost % 100);
    }
}
