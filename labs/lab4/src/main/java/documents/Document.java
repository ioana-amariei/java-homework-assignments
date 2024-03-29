/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

package documents;

import exceptions.InvalidAuthorException;
import exceptions.InvalidTitleException;
import exceptions.InvalidYearException;

import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Document implements Serializable {
    private String title;
    private String path;
    private int year;
    private List <String> authors = new LinkedList <>();

    public Document(String title, String path, int year, String... authors) {
        setTitle(title);
        setPath(path);
        setYear(year);
        setAuthors(authors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;

        Document document = (Document) o;

        if (year != document.year) return false;
        if (!title.equals(document.title)) return false;
        if (!path.equals(document.path)) return false;
        return authors != null ? authors.equals(document.authors) : document.authors == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + path.hashCode();
        result = 31 * result + year;
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().equals("")) {
            throw new IllegalArgumentException("Title should not be empty");
        }
        if (!title.matches("[a-zA-Z ]+")) {
            throw new InvalidTitleException(title);
        }
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException exception) {
            String message = exception.getMessage();
            System.out.println(message);
        }
        this.path = path;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new InvalidYearException(year);
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) throw new InvalidYearException("Impossible, the current year is 2018.");
        this.year = year;
    }

    public List <String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        for (String author : authors) {
            if (author == null || author.trim().equals("")) {
                throw new IllegalArgumentException("Author should contain a name");
            }
            if (!author.matches("[.a-zA-Z ]+")) {
                throw new InvalidAuthorException(author);
            }
        }

        this.authors.addAll(Arrays.asList(authors));
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}