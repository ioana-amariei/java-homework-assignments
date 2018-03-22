/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package commands;

import catalog.Catalog;
import documents.Article;
import documents.Book;
import documents.Manual;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** The Command for adding a document - ConcreteCommand #1 */
public class AddCommand implements Command {
    private Catalog catalog;
    private List<String> parameters;
    private static final List<String> documentTypes = Arrays.asList("book", "article", "manual");

    public AddCommand(Catalog catalog, List<String> parameters) {
        if(parameters.size() < 4) {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }

        if(!documentTypes.contains(parameters.get(0))) {
            throw new IllegalArgumentException("Document type not supported.");
        }

        this.catalog = catalog;
        this.parameters = new LinkedList <>(parameters);

    }

    public void execute(){
        String title = parameters.get(1);
        String path = parameters.get(2);
        int year = Integer.parseInt(parameters.get(3));

        List<String> authors = parameters.subList(4, parameters.size());

        String documentType = parameters.get(0);
        switch (documentType) {
            case "book":
                catalog.add(new Book(title, path, year, authors.toArray(new String[0])));
                break;
            case "article":
                catalog.add(new Article(title, path, year, authors.toArray(new String[0])));
                break;
            case "manual":
                catalog.add(new Manual(title, path, year, authors.toArray(new String[0])));
                break;
        }
    }
}
