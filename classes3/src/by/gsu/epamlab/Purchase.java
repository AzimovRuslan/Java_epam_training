package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public static final String PRODUCT_NAME = "Book";
    public static final int PRICE_BOOK = 1400;
    private int number;
    private double percent;
    private WeekDay day;

    public Purchase(int number, double percent, WeekDay day){
        this.number = number;
        this.percent = percent;
        this.day = day;
    }

    public Purchase(){
        this(0, 0, null);
    }

    public int getCost(){
        return (int)Math.round(PRICE_BOOK * number * ((100.0 - percent) / 100));
    }

    public int getNumber() {
        return number;
    }

    public WeekDay getDay() {
        return day;
    }

    @Override
    public String toString() {
        return number + ";" + percent + ";" + day + ";" + Utilities.convertMoney(getCost());
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.getNumber();
    }
}
