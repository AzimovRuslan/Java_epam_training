package by.gsu.epamlab;

import java.util.Scanner;

public class PricePurchase extends Purchase{
    private final Byn discount;

    public PricePurchase(Scanner scanner){
        super(scanner);
        this.discount = new Byn(scanner.nextInt());
    }

    public PricePurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}

