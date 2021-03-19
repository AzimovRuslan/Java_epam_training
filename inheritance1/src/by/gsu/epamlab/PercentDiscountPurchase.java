package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private static final int EXCESS_AMOUNT = 3;
    private final double percentDiscount;

    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.percentDiscount = scanner.nextDouble();
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getNumber() > EXCESS_AMOUNT) {
            cost = cost.multiplicationValue(1.0 - percentDiscount / 100);
        }
        else {
            cost = getCost();
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }

}

