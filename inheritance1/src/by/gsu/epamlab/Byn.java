package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    private int financialValue;

    public Byn(int financialValue){
        this.financialValue = financialValue;
    }

    public Byn() {
        this(0);
    }

    public Byn(Byn byn) {
        this(byn.financialValue);
    }

    public Byn getCost(int number) {
        return new Byn(financialValue * number);
    }

    public Byn sumValue(Byn byn) {
        financialValue += byn.financialValue;
        return this;
    }

    public Byn subtractionValue(Byn byn) {
        financialValue -= byn.financialValue;
        return this;
    }

    public Byn multiplicationValue(int value) {
        financialValue *= value;
        return this;
    }

    public Byn multiplicationValue(double value) {
        financialValue *= value;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", financialValue / 100, financialValue % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return financialValue == byn.financialValue;
    }

    @Override
    public int compareTo(Byn byn) {
        return financialValue - byn.financialValue;
    }
}
