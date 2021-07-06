package by.gsu.epamlab.exceptions;

public class CsvLineException extends Throwable {
    private String cause;

    public CsvLineException(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return cause;
    }
}
