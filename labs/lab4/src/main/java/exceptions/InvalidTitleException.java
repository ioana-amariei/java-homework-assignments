/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package exceptions;

public class InvalidTitleException extends RuntimeException{
    public InvalidTitleException(String title){
        super("Title should contain characters and spaces: " + title);
    }
}
