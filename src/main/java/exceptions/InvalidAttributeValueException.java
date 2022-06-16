package exceptions;

public class InvalidAttributeValueException extends RuntimeException{
    private static final long serialVersionUID = -3042206311834763287L;

    public InvalidAttributeValueException() { super();}

    public InvalidAttributeValueException(String message) {
        super(message);
    }

    public InvalidAttributeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAttributeValueException(Throwable cause) {
        super(cause);
    }
}
