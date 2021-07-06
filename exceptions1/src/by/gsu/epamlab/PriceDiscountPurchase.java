package by.gsu.epamlab;

import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        setDiscount(discount);
    }

    public void setDiscount(Byn discount) {
        if (discount.getKopecks() <= 0 || discount.getKopecks() >= 100) {
            throw new NonPositiveArgumentException(discount.getKopecks(), NumField.DISCOUNT);
        }
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
