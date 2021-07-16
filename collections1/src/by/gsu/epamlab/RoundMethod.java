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

    public int round(double value, int d) {
        int[] tenPow = {1, 2, 3, 4, 5, 6, 7, 8};
        return (int) roundFunction(value / Math.pow(10, tenPow[d]) * Math.pow(10, tenPow[d]));
    }
}
