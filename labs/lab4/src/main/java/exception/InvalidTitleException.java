/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package exception;

public class InvalidTitleException extends RuntimeException{
    public InvalidTitleException(String title){
        super("Title should contain characters and spaces: " + title);
    }
}
