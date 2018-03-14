/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package catalog;

import document.Document;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Catalog {
    public List <Document> documents;

    public Catalog() {
        this.documents = new LinkedList <>();
    }

    public void add(Document... documents) {
        this.documents.addAll(Arrays.asList(documents));
    }

    public void list() {
        System.out.println(documents);
    }

    public Catalog load(String externalFile) {
        return new Catalog();
    }

    public void save(String externalFile) {

    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }
}
