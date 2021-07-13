package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.Priceable;

public class Purchase<T extends Priceable, N extends Number>{
    private T item;
    private N quantity;

    public Purchase(T item, N quantity) {
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
        return item + Constants.DELIMITER + quantity + Constants.DELIMITER + getCost();
    }
}
