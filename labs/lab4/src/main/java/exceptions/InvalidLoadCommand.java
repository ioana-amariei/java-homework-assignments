/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidLoadCommand extends RuntimeException{
    public InvalidLoadCommand(String command) {
        super("Invalid command: " + command + "\n" +
            "Format: <load> <path> \n");
    }
}
