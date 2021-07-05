package by.gsu.epamlab;

public class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public int getKopecks() {
        return kopecks;
    }

    public Byn() {
        this(0);
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn add(Byn byn) {
        kopecks += byn.kopecks;
        return this;
    }

    public Byn sub(Byn byn) {

        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(int value) {
        return new Byn(kopecks * value);
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        kopecks = roundMethod.round(kopecks * value, d);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Byn byn = (Byn) object;
        return kopecks == byn.kopecks;
    }

    @Override
    public int compareTo(Byn byn) {
        return kopecks - byn.kopecks;
    }
}
