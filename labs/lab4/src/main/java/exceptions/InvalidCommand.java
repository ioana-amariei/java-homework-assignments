/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidCommand extends RuntimeException {
    public InvalidCommand(String command) {
        super("Invalid command: " + command + ".\n");
    }
}
