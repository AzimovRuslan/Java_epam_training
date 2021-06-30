package by.gsu.epamlab;

public enum RoundMethod {
    ROUND {
        double roundFunction(double d) {
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
        int[] tenPow = {1, 10, 100, 1000, 10000};
        return (int)roundFunction(value / tenPow[d]) * tenPow[d];
    }
}
