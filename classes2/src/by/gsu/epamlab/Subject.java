package by.gsu.epamlab;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject(String name, Material material, double volume){
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public Subject(){
        this(null, null, 0);
    }

    public double getMass(){
        return material.getDensity() * volume;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return name + ";" + material + ";" + volume +  ";" + getMass();
    }
}
