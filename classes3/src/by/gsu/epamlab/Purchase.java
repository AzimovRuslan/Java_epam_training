package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public static final String PRODUCT_NAME = "Book";
    public static final int PRICE_BOOK = 1400;
    private int numberOfPurchasedUnits;
    private double discountPercent;
    private WeekDay weekDay;

    public Purchase(int numberOfPurchasedUnits, double discountPercent, WeekDay weekDay){
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
        this.discountPercent = discountPercent;
        this.weekDay = weekDay;
    }

    public Purchase(){
        this(0, 0, null);
    }

    public int getCost(){
        return (int)Math.round(PRICE_BOOK * numberOfPurchasedUnits * ((100.0 - discountPercent) / 100));
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    @Override
    public String toString() {
        return numberOfPurchasedUnits + ";" + discountPercent + ";" + weekDay + ";" + Utilities.convertMoney(getCost());
    }

    @Override
    public int compareTo(Purchase purchase) {
        return numberOfPurchasedUnits - purchase.getNumberOfPurchasedUnits();
    }
}
