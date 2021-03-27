package by.gsu.epamlab;

public class PercentDiscountPurchase extends AbstractPurchase{
    private static final int EXCESS_AMOUNT = 3;
    private final double percentDiscount;

    public PercentDiscountPurchase(Product product, int number, double percentDiscount) {
        super(product, number);
        this.percentDiscount = percentDiscount;
    }

    @Override
    protected Byn getFullCost(Byn originalCost) {
        Byn cost = originalCost;
        if (getNumber() > EXCESS_AMOUNT) {
            cost = originalCost.mul(1.0 - percentDiscount / 100, RoundMethod.ROUND, 2);
        }
        return cost;
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }
}
