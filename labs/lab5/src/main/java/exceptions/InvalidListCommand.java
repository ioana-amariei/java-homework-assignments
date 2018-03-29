/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidListCommand extends RuntimeException {
    public InvalidListCommand(String command) {
        super("Invalid command: " + command + "\n" +
            "Format: list \n");
    }
}
