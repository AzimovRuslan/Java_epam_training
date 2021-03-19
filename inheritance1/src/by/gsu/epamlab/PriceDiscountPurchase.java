package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private double discount;
    
    public PriceDiscountPurchase(Scanner scanner){
        super(scanner);
        this.discount = scanner.nextDouble();
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public Byn getCost() {
        return (super.getPrice().subtractionValue((int)Math.round(discount))).multiplicationValue(super.getNumber());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString();
    }

    public String toString() {
        return fieldsToString() + ";" + discount + ";" + getCost();
    }
}
