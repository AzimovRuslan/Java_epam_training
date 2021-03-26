package by.gsu.epamlab;

public class Product {
    private String name;
    private Byn price;

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
        this(null, null);
    }

    public Byn getPrice() {
        return new Byn(price);
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }
}
