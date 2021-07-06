package by.gsu.epamlab;

public enum NumField {
    PRICE(" in price"),
    NUMBER(" in number"),
    DISCOUNT(" in discount");

    public final String name;

    NumField(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
