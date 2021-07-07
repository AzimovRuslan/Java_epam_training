package by.gsu.asoilab;

public class Purchase{
    private Product product;
    private double number;

    public Purchase(Product product, double number) {
        this.product = product;
        this.number = number;
    }
    public Byn getCost() {
        return product.getPrice().mul(number, RoundMethod.ROUND, 3);
    }

    @Override
    public String toString() {
        return product + ";" + number;
    }
}
