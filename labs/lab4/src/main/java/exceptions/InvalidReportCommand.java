/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidReportCommand extends RuntimeException{
    public InvalidReportCommand(String command) {
        super("Invalid command: " + command + "\n" +
            "Format: <report> <document type> <path> \n");
    }
}
