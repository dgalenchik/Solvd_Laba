package exceptions;

public class InvalidAuthorizationException extends Exception {
    public InvalidAuthorizationException() {
    }

    public InvalidAuthorizationException(String message) {
        super(message);
    }

    public InvalidAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAuthorizationException(Throwable cause) {
        super(cause);
    }

    public InvalidAuthorizationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
