import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {
    public static void main(String[] args){
        final Material STEEL = Material.STEEL;
        Subject wire = new Subject("wire", STEEL, 0.03);

        System.out.println(wire);

        final Material COPPER = Material.COPPER;
        wire.setMaterial(COPPER);

        System.out.println("The wire mass is " + wire.getMass());
    }
}
