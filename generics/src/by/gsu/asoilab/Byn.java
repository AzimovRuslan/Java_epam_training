package by.gsu.asoilab;

public class Byn implements Comparable<Byn>{
    private final int kopecks;

    public int getKopecks() {
        return kopecks;
    }

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn sub(Byn byn) {
        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks * value, d));
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }

    @Override
    public int compareTo(Byn byn) {
        return kopecks - byn.kopecks;
    }
}
