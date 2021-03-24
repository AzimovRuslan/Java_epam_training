package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    private Product product;
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
        return getFullCost(originalCost);
    }

    @Override
    public String toString() {
        return product + ";" + number + ";" + getCost();
    }
}
