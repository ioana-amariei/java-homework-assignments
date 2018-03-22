/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import catalog.Catalog;

import java.io.IOException;
import java.util.List;

/** The Command for saving the content of the catalog to an external file - ConcreteCommand #3 */
public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, List <String> parameters) {
        if(parameters.size() != 1){
            throw new IllegalArgumentException("The command is not valid.");
        }

        this.catalog = catalog;
        this.path = parameters.get(0);
    }

    @Override
    public void execute() throws IOException {
        catalog.save(path);
    }
}
