package by.gsu.epamlab;

public class TransportPurchase extends AbstractPurchase{
    private final int transportCost;

    public TransportPurchase(Product product, int number, int transportCost) {
        super(product, number);
        this.transportCost = transportCost;
    }

    @Override
    protected Byn getFullCost(Byn originalCost) {
        return originalCost.add(transportCost);
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return this.getCost().getKopecks() - o.getCost().getKopecks();
    }
}
