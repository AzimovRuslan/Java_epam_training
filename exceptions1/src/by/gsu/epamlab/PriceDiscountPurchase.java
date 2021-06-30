package by.gsu.epamlab;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase() {}

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

    @Override
    public String fieldsToTable() {
        return super.fieldsToTable() + "     " + discount;
    }
}
