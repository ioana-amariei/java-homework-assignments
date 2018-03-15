/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package exception;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String type){
        super("Type should contain only lower characters: " + type);
    }
}
