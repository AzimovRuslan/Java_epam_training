package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    private int financialValue;

    public Byn(int financialValue){
        this.financialValue = financialValue;
    }

    public Byn(){
        this(0);
    }

    public int increaseValue(int increase){
        return financialValue += increase;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", financialValue / 100, financialValue % 100);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Byn byn = (Byn) object;
        return financialValue == byn.financialValue;
    }

    @Override
    public int compareTo(Byn byn) {
        return financialValue - byn.financialValue;
    }
}
