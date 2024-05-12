package Exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
