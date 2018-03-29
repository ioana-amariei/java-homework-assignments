/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidAuthorException extends RuntimeException{
    public InvalidAuthorException(String author){
        super("Author should contain characters and spaces: " + author);
    }
}
