package utils;

import beans.DecimalResult;
import beans.HalfResult;
import beans.Result;

public class ClassFactory {
    public static Result getClassFromFactory(String filename){

        switch (filename) {
            case "src/main/java/results.csv":
                return new Result();
            case "src/main/java/results.xml":
                return new DecimalResult();
            case "src/main/java/results2.csv":
                return new HalfResult();
            default:
                throw new IllegalArgumentException();
        }
    }
}
