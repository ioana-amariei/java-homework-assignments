/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

import document.Document;
import exception.InvalidTypeException;

import java.util.List;

public class Manual extends Document {
    private String type;

    public Manual(String title, String path, int year, String ... authors) {
        super(title, path, year, authors);
    }

    @Override
    public String toString() {
        return "Manual{" + super.toString() + ", " +
                "type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null || type.trim().equals("")){
            throw new IllegalArgumentException("Type should not be empty.");
        }
        if(!type.matches("[a-z]+")){
            throw new InvalidTypeException(type);
        }

        this.type = type;
    }
}