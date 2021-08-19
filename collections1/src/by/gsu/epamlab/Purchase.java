package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

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
        this(null, new Byn(0), 0);
    }

    public Purchase(Scanner sc) {
        name = sc.next();
        price = new Byn(sc.nextInt());
        number = sc.nextInt();
    }

    public Byn getCost() {
        return price.mul(number, RoundMethod.ROUND, 0);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Byn getPrice() {
        return price;
    }

    protected String fieldsToString() {
        return name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return getName().equals(purchase.getName()) && getPrice().equals(purchase.getPrice());
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + price.hashCode();
    }
}
