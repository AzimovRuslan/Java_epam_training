package by.gsu.epamlab;

import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        setPrice(price);
        setNumber(number);
    }

    public final void setNumber(int number) {
        if (number <= 0) {
            throw new NonPositiveArgumentException(number, NumField.NUMBER);
        }
        this.number = number;
    }

    public final void setPrice(Byn price) {
        if (price.getKopecks() <= 0) {
            throw new NonPositiveArgumentException(price.getKopecks(), NumField.PRICE);
        }
        this.price = price;
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
