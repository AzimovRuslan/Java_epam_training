package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.Priceable;

public class Purchase implements Comparable<Purchase>{
    private Priceable item;
    private Number quantity;

    public Purchase(Priceable item, Number quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Priceable getItem() {
        return item;
    }

    public Byn getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + ";" + quantity + ";" + getCost();
    }

    @Override
    public int compareTo(Purchase purchase) {
        return getCost().compareTo(purchase.getCost());
    }
}
