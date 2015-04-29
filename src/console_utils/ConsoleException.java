package console_utils;

/**
 * Created by Lucien.Minot on 4/2/2015.
 */
public class ConsoleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConsoleException(Throwable t) {
        super(t);
    }
}
