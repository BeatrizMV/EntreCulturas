package exceptions;

public class DaoException extends Exception{
    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable error) {
        super(message, error);
    }

    public DaoException(String message) {
        super(message);
    }
}
