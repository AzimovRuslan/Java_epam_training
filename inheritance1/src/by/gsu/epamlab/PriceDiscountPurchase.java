package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private final Byn discount;
    
    public PriceDiscountPurchase(Scanner scanner){
        super(scanner);
        this.discount = new Byn(scanner.nextInt());
    }

    @Override
    public Byn getCost() {
        return super.getCost().subtractionValue(discount.multiplicationValue(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
