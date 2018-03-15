/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package exception;

public class InvalidYearException extends RuntimeException {
    public InvalidYearException(String message){
        super(message);
    }
    public InvalidYearException(int year){
        super("Invalid year: " + year);
    }
}

