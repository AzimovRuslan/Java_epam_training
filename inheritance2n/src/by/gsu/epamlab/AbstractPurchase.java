package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    private final Product product;
    private int number;

    public AbstractPurchase(Product product, int number){
        this.product = product;
        this.number = number;
    }

    public AbstractPurchase(){
        this(null, 0);
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    protected abstract Byn getFullCost(Byn originalCost);

    public Byn getCost(){
        Byn originalCost = product.getPrice().mul(number);
        Byn finalCost = getFullCost(originalCost);
        return finalCost.roundByn(RoundMethod.FLOOR, 2);
    }

    public String fieldsToString() {
        return product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return getCost().compareTo(purchase.getCost());
    }
}
