package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{

    public PriceDiscountPurchase(Scanner scanner){
        super(scanner);
    }

    @Override
    public Byn getCost() {
        int DISCOUNT = 20;
        return new Byn((getPrice() - DISCOUNT) * getNumber());
    }
}
