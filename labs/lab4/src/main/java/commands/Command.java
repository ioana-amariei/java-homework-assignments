/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import java.io.IOException;

/** The Command interface */
public interface Command {
    void execute() throws IOException, ClassNotFoundException;
}
