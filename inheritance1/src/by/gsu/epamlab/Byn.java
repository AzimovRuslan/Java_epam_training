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

    public Byn add(Byn byn) {
        financialValue += byn.financialValue;
        return this;
    }

    public Byn sub(Byn byn) {
        financialValue -= byn.financialValue;
        return this;
    }

    public Byn mul(int value) {
        financialValue *= value;
        return this;
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        financialValue = roundMethod.round(financialValue * value, d);
        return this;
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

    public enum RoundMethod {
        ROUND {
            double roundFunction(double d){
                return Math.round(d);
            }
        },
        FLOOR {
            double roundFunction(double d){
                return Math.floor(d);
            }
        },
        CEIL {
            double roundFunction(double d){
                return Math.ceil(d);
            }
        };
        abstract double roundFunction(double value);

        public int round(double value, int d){
            int[] tenPow = {1, 2, 3, 4, 5, 6, 7, 8};
            return (int)roundFunction(value / Math.pow(10, tenPow[d]) * Math.pow(10, tenPow[d]));
        }
    }
}
