/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package catalog;

import document.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Catalog {
    private List <Document> documents;

    public Catalog() {
        this.documents = new LinkedList <>();
    }

    /**
     * Adds a new entry into the catalog.
     * @param documents the document/documents to be added
     */
    public void add(Document ... documents) {
        this.documents.addAll(Arrays.asList(documents));
    }

    /**
     * Prints the content of the catalog on the screen.
     */
    public void list() {
        System.out.println(documents);
    }

    /**
     * Opens the document using the native operating system application.
     * @param filename the name of the file
     * @throws IOException
     */
    public void open(String filename) throws IOException {
        //text file, should be opening in default text editor
        File file = new File(filename);

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
    }

    /**
     * Saves the catalog to an external file (either as a text or binary, using object serialization).
     *
     * @param externalFilePath the external file path for catalog to be saved
     */
    public void save(String externalFilePath) {

    }

    /**
     * Loads the catalog from an external file.
     *
     * @param externalFilePath the external file path from where the catalog is loaded
     * @return a catalog of documents
     */
    public static Catalog load(String externalFilePath) {
        return new Catalog();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }
}
