/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String type){
        super("Type should contain only lower characters: " + type);
    }
}
