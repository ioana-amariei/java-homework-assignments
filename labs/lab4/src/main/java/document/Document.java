/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package document;

import java.util.List;


public abstract class Document {
    private String title;
    private String path;
    private int year;
    private List <String> authors;

    public Document(String title, String path, int year, List <String> authors) {

        this.title = title;
        this.path = path;
        this.year = year;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List <String> getAuthors() {
        return authors;
    }

    public void setAuthors(List <String> authors) {
        this.authors = authors;
    }
}
