package documents; /**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler Octavian B5
 */

import exceptions.InvalidTypeException;

public class Manual extends Document {
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manual)) return false;
        if (!super.equals(o)) return false;

        Manual manual = (Manual) o;

        return type != null ? type.equals(manual.type) : manual.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public Manual(String title, String path, int year, String... authors) {

        super(title, path, year, authors);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().equals("")) {
            throw new IllegalArgumentException("Type should not be empty.");
        }
        if (!type.matches("[a-z]+")) {
            throw new InvalidTypeException(type);
        }

        this.type = type;
    }

    @Override
    public String toString() {
        return "Manual{" + super.toString() + ", " +
                "type='" + type + '\'' +
                '}' + '\n';
    }
}