package exception;

/**
 * TypeException.
 * <p>
 * 26 August 2018
 *
 * @author Dmitry Krivolap
 * @version 1.0
 */
public class TypeException extends Exception {
    public TypeException() {
    }

    public TypeException(String message) {
        super(message);
    }

    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
