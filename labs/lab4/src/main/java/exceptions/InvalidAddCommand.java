/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidAddCommand extends RuntimeException {
    public InvalidAddCommand(String command) {
        super("Invalid command: " + command + "\n" +
                "Format: <add> <document type> <title> <path> <year> <authors>");
    }
}
