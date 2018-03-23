/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidSaveCommand extends RuntimeException{
    public InvalidSaveCommand(String command) {
        super("Invalid command: " + command + "\n" +
            "Format: <save> <path> \n");
    }
}
