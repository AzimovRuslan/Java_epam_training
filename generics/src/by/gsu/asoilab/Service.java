package by.gsu.asoilab;

public class Service extends Product{
    private int numberUsers;

    public Service(String name, Byn totalCost, int numberUsers) {
        super(name, totalCost.div(numberUsers, RoundMethod.ROUND, 3));
        this.numberUsers = numberUsers;
    }
}
