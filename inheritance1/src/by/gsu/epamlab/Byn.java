package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    private int financialValue;

    public int sumValue(int value){
        return financialValue += value;
    }

    public int subtractionValue(int value){
        return financialValue -= value;
    }

    public int multiplicationValue(int value){
        return financialValue *= value;
    }

    public double multiplicationValue(double value){
        return financialValue *= value;
    }

    public Byn(int financialValue){
        this.financialValue = financialValue;
    }

    public Byn(){
        this(0);
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
