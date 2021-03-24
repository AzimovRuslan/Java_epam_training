package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase{
    private final Byn discount;

    public PriceDiscountPurchase(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = discount;
    }

    @Override
    protected Byn getFullCost(Byn originalCost) {
        return originalCost.sub(discount.mul(getNumber()));
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return this.getCost().getKopecks() - o.getCost().getKopecks();
    }
}
