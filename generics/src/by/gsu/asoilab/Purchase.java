package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.ItemInterface;

public class Purchase{
    private ItemInterface item;
    private double number;

    public Purchase(ItemInterface item, double number) {
        this.item = item;
        this.number = number;
    }

    public Byn getCost() {
        return item.getPrice().mul(number, RoundMethod.ROUND, 3);
    }

    @Override
    public String toString() {
        return item + ";" + number + ";" + getCost();
    }
}
