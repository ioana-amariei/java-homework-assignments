/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidPlayCommand extends RuntimeException {
    public InvalidPlayCommand(String command) {
        super("Invalid command: " + command + "\n" +
            "Format: <play> <path> \n");
    }
}
