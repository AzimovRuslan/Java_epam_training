package exceptions;

public class SourceException extends Exception{
    private String message;

    public SourceException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
