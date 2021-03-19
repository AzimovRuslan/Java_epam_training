package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private static final int EXCESS_AMOUNT = 3;
    private static final double PERCENT_DISCOUNT = 3.1;

    public PercentDiscountPurchase(Scanner scanner){
        super(scanner);
    }

    @Override
    public int getCost() {
        int cost = 0;
        if(getNumber() > EXCESS_AMOUNT){
            cost = (int)Math.round(getPrice() * getNumber() * (1.0 - PERCENT_DISCOUNT / 100));
        }
        else {
            cost = getPrice() * getNumber();
        }
        return cost;
    }
}
