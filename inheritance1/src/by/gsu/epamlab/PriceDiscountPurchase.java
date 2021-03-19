package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private static final int DISCOUNT = 20;

    public PriceDiscountPurchase(Scanner scanner){
        super(scanner);
    }

    @Override
    public int getCost() {
        return (getPrice() - DISCOUNT) * getNumber();
    }
}
