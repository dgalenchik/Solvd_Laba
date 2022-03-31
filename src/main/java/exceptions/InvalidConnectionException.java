package exceptions;

public class InvalidConnectionException extends Exception{
    public InvalidConnectionException() {
    }

    public InvalidConnectionException(String message) {
        super(message);
    }

    public InvalidConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConnectionException(Throwable cause) {
        super(cause);
    }

    public InvalidConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
