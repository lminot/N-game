package console_utils;

import java.io.PrintWriter;
import java.io.Reader;

/**
 * Created by Lucien.Minot on 4/2/2015.
 */
public abstract class TextDevice {
    public abstract TextDevice printf(String fmt, Object... params)
            throws ConsoleException;

    public abstract String readLine() throws ConsoleException;

    public abstract char[] readPassword() throws ConsoleException;

    public abstract Reader reader() throws ConsoleException;

    public abstract PrintWriter writer() throws ConsoleException;
}
