package documents; /**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

import exceptions.InvalidTitleException;

import java.util.Objects;

import static java.util.Objects.*;


public class Article extends Document {
    private String journal;
    private String conference;

    public Article(String title, String path, int year, String... authors) {
        super(title, path, year, authors);
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        if (journal == null || journal.trim().equals("")) {
            throw new IllegalArgumentException("Journal name should not be empty");
        }
        if (!journal.matches("[a-zA-z ]+")) {
            throw new InvalidTitleException(journal);
        }

        this.journal = journal;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        if (isNull(conference) || conference.trim().equals("")) {
            throw new IllegalArgumentException("Conference name should not be empty");
        }
        if (!conference.matches("[a-zA-z1-9 ]+")) {
            throw new InvalidTitleException(conference);
        }

        this.conference = conference;
    }

    @Override
    public String toString() {
        return "Article{" + super.toString() + ", " +
                "journal='" + journal + '\'' +
                ", conference='" + conference + '\'' +
                '}' + '\n';
    }
}