package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.Priceable;

public class Purchase<T extends Priceable, E extends Number> implements Comparable<Purchase>{
    private T item;
    private E quantity;

    public Purchase(T item, E quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T getItem() {
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
