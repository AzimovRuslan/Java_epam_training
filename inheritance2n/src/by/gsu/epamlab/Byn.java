package by.gsu.epamlab;

public class Byn {
    private int kopecks;

    public Byn(int kopecks) {
        this.kopecks = kopecks;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public int getKopecks() {
        return kopecks;
    }

    public Byn add(int value) {
        return new Byn(kopecks += value);
    }

    public Byn sub(Byn byn) {
        return new Byn(kopecks -= byn.kopecks);
    }

    public Byn mul(double value) {
        return new Byn(kopecks *= value);
    }

    public Byn div(double value) {
        return new Byn(kopecks /= value);
    }

    public Byn roundByn(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks , d));
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }
}
