package by.gsu.epamlab;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase() {
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    public int getNumber() {
        return number;
    }

    protected String fieldsToString() {
        return name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    public String getName() {
        return name;
    }
}
