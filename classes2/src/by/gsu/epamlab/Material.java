package by.gsu.epamlab;

public enum Material {
    STEEL ("steel", 7850.0),
    COPPER ("copper", 8500.0);

    private final String name;
    private final double density;

    Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    Material(){
        this(null, 0);
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return name + ";" + density;
    }
}
