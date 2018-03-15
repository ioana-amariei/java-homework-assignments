/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

import document.Document;

import java.util.List;

public class Book extends Document {
    private String publisher;

    public Book(String title, String path, int year, String ... authors) {
        super(title, path, year, authors);

    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() + ", " +
                "publisher='" + publisher + '\'' +
                '}';
    }
}