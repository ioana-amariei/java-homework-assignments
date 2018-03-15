/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package exception;

public class InvalidAuthorException extends RuntimeException{
    public InvalidAuthorException(String author){
        super("Author should contain characters and spaces: " + author);
    }
}
