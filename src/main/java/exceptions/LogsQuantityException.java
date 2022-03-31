package exceptions;

public class LogsQuantityException extends Exception{
    public LogsQuantityException() {
    }

    public LogsQuantityException(String message) {
        super(message);
    }

    public LogsQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogsQuantityException(Throwable cause) {
        super(cause);
    }

    public LogsQuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
