package by.gsu.epamlab;

public class TransportPurchase extends AbstractPurchase{
    private final Byn transportCost;

    public TransportPurchase(Product product, int number, Byn transportCost) {
        super(product, number);
        this.transportCost = transportCost;
    }

    @Override
    protected Byn getFullCost(Byn originalCost) {
        return originalCost.add(transportCost);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + transportCost;
    }
}
