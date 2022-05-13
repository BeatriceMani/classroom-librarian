package exceptions;

public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 750717893243596583L;

    public BookNotFoundException() { super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
