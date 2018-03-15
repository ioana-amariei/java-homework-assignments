/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package document;

import exception.InvalidAuthorException;
import exception.InvalidTitleException;
import exception.InvalidYearException;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public abstract class Document {
    private String title;
    private String path;
    private int year;
    private List<String> authors;

    public Document(String title, String path, int year, String ... authors) {
        setTitle(title);
        setPath(path);
        setYear(year);
        setAuthors(authors);

        //???????
        //this.title = title;
        //this.path = path;
        //this.year = year;
        //this.authors.addAll(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().equals("")){
            throw new IllegalArgumentException("Title shoul not be empty");
        }
        if(!title.matches("[a-zA-Z ]+")){
            throw new InvalidTitleException(title);
        }
        this.title = title;
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

    public void setYear(int year) {
        if (year < 0) {
            throw new InvalidYearException(year);
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) throw new InvalidYearException("Impossible, the current year is 2018.");
        this.year = year;
    }

    public void setAuthors(String ... authors) {
        List<String> authorList = new LinkedList <>();
        authorList.addAll(Arrays.asList(authors));

        for(String author : authorList){
            if (author == null || author.trim().equals("")){
                throw new IllegalArgumentException("Author should contain a name");
            }
            if(!author.matches("[a-zA-Z ]+")){
                throw new InvalidAuthorException(author);
            }
        }

        this.authors.addAll(Arrays.asList(authors));
    }

    public String getPath() {
        return path;
    }

    public int getYear() {
        return year;
    }

    public List <String> getAuthors() {
        return authors;
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
}