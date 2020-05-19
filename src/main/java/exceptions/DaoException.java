package exceptions;

public class DaoException extends Exception{
    public DaoException(String message, Throwable error) {
        super(message, error);
    }

    public DaoException(String message) {
        super(message);
    }
}
