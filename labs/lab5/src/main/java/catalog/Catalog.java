/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package catalog;

import documents.Document;

import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Manipulates the contents of a document catalog (add, save, load, open, list).
 * The Receiver class in Command Design Pattern
 */
public class Catalog implements Serializable {
    private Set <Document> documents;

    public Catalog() {
        this.documents = new HashSet <>();
    }

    // Loads the catalog from an external file.
    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileInputStream);

        Catalog catalog = (Catalog) in.readObject();
        fileInputStream.close();

        return catalog;
    }

    public Set <Document> getDocuments() {
        return documents;
    }

    // Adds a new entry into the catalog.
    public void add(Document document) {
        if (!documents.contains(document)) {
            this.documents.add(document);
        }
    }

    // Prints the content of the catalog on the screen.
    public void list() {
        System.out.println(documents);
    }


    // Opens the documents using the native operating system application.
    public void open(String filename) throws IOException {
        //text file, should be opening in default text editor
        File file = new File(filename);

        //first check if Desktop is supported by Platform or not
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    //Saves the catalog to an external file (either as a text or binary, using object serialization).
    public void save(String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        out.writeObject(this);
        out.flush();

        fileOutputStream.close();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "documents=" + documents +
                '}';
    }
}
