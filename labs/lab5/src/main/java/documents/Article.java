package documents; /**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

import exceptions.InvalidTitleException;

import static java.util.Objects.isNull;


public class Article extends Document {
    private String journal;
    private String conference;

    public Article(String title, String path, int year, String... authors) {
        super(title, path, year, authors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        if (!super.equals(o)) return false;

        Article article = (Article) o;

        if (journal != null ? !journal.equals(article.journal) : article.journal != null) return false;
        return conference != null ? conference.equals(article.conference) : article.conference == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        result = 31 * result + (conference != null ? conference.hashCode() : 0);
        return result;
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