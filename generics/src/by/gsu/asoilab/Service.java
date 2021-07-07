package by.gsu.asoilab;

import by.gsu.asoilab.interfaces.ItemInterface;

public class Service implements ItemInterface {
    private String name;
    private Byn totalCost;
    private int numberUsers;

    public Service(String name, Byn totalCost, int numberUsers) {
        this.name = name;
        this.totalCost = totalCost;
        this.numberUsers = numberUsers;
    }

    @Override
    public Byn getPrice() {
        return totalCost.div(numberUsers, RoundMethod.ROUND, 3);
    }

    @Override
    public String toString() {
        return name + ";" + getPrice();
    }
}
