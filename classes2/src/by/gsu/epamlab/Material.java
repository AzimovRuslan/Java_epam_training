package by.gsu.epamlab;

public class Material {
    private final String name;
    private final double density;

    public Material(String name, double densityMaterial){
        this.name = name;
        this.density = densityMaterial;
    }

    public Material(){
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
