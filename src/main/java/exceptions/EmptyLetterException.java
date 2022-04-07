package exceptions;

public class EmptyLetterException extends Exception {
    public EmptyLetterException() {
    }

    public EmptyLetterException(String message) {
        super(message);
    }

    public EmptyLetterException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyLetterException(Throwable cause) {
        super(cause);
    }

    public EmptyLetterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
