/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package document;

import java.util.List;


public class Article extends Document {
    private String journal;
    private String conference;

    public Article(String title, String path, int year, List <String> authors) {
        super(title, path, year, authors);
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    @Override
    public String toString() {
        return "Article{" + super.toString() + ", " +
                "journal='" + journal + '\'' +
                ", conference='" + conference + '\'' +
                '}';
    }

}
