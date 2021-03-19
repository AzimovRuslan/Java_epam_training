package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private static final int EXCESS_AMOUNT = 3;

    public PercentDiscountPurchase(Scanner scanner){
        super(scanner);
    }

    @Override
    public Byn getCost() {
        int cost = 0;
        if(getNumber() > EXCESS_AMOUNT){
            double percentDiscount = 3.1;
            cost = (int)Math.round(getPrice() * getNumber() * (1.0 - percentDiscount / 100));
        }
        else {
            cost = getPrice() * getNumber();
        }
        return new Byn(cost);
    }
}
