package by.gsu.asoilab;

public class DiscountProduct extends Product{

    private Byn discount;

    public DiscountProduct(String name, Byn price, Byn discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    public Byn getPrice() {
        return super.getPrice().sub(discount);
    }
}
