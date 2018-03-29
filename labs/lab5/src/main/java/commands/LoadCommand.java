/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import catalog.Catalog;
import exceptions.InvalidLoadCommand;

import java.io.IOException;
import java.util.List;

/** The Command for loading the content of the catalog from an external file - ConcreteCommand #4 */
public class LoadCommand implements Command {
    private String path;

    public LoadCommand(List <String> parameters) {
        String command = "load" + parameters;

        if(parameters.size() != 1){
            throw new InvalidLoadCommand(command);
        }

        this.path = parameters.get(0);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        Catalog.load(path);
    }
}
