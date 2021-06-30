package Exceptions;

public class WrongAmountArgumentsException extends Exception {
    public WrongAmountArgumentsException(String message) {
        super(message);
    }

    public WrongAmountArgumentsException(Throwable cause) {
        super(cause);
    }
}
