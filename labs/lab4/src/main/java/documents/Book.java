package documents; /**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

public class Book extends Document {
    private String publisher;

    public Book(String title, String path, int year, String... authors) {
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
        return "documents.Book{" + super.toString() + ", " +
                "publisher='" + publisher + '\'' +
                '}';
    }
}