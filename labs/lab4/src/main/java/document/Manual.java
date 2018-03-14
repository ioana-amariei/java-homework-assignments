/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

package document;

import java.util.List;


public class Manual extends Document {
    private String domainOfUse;

    public Manual(String title, String path, int year, List <String> authors) {
        super(title, path, year, authors);
    }

    public String getDomainOfUse() {
        return domainOfUse;
    }

    public void setDomainOfUse(String domainOfUse) {
        this.domainOfUse = domainOfUse;
    }

    @Override
    public String toString() {
        return "Manual{" + super.toString() + ", " +
                "domainOfUse='" + domainOfUse + '\'' +
                '}';
    }
}
