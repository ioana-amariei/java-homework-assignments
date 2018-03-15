/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidYearException extends RuntimeException {
    public InvalidYearException(String message){
        super(message);
    }
    public InvalidYearException(int year){
        super("Invalid year: " + year);
    }
}

