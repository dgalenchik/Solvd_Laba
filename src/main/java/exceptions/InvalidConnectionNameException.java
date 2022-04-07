package exceptions;

public class InvalidConnectionNameException extends Exception {
    public InvalidConnectionNameException() {
    }

    public InvalidConnectionNameException(String message) {
        super(message);
    }

    public InvalidConnectionNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConnectionNameException(Throwable cause) {
        super(cause);
    }

    public InvalidConnectionNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
