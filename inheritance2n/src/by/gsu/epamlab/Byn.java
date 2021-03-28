package by.gsu.epamlab;

public final class Byn implements Comparable<Byn> {
    private final int kopecks;

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn() {
        this(0);
    }

    public Byn add(Byn byn) {
        return new Byn(kopecks + byn.kopecks);
    }

    public Byn sub(Byn byn) {
        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(int value) {
        return new Byn(kopecks * value);
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks * value, d));
    }

    public Byn roundByn(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks, d));
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }

    @Override
    public int compareTo(Byn o) {
        return kopecks - o.kopecks;
    }
}
