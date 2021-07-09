package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.Priceable;

public class Product implements Priceable {
    private String name;
    private Byn price;

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Byn getPrice() {
        return price;
    }

    public String fieldsToString() {
        return name + Constants.DELIMITER + price;
    }

    @Override
    public String toString() {
        return fieldsToString();
    }
}
