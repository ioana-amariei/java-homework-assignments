/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.util.*;

public class Student extends Person {
    private Set<Project> preferences;

    /**
     * Constructor with arguments
     * @param name a string representing the name of the student
     * @param email a string representing the personal email
     */
    public Student(String name, String email) {
        /**
         * Invokes the constructor from the superclass
         */
        super(name, email);

        this.preferences = new HashSet <>();
    }

    /**
     * Gets the list of preferred projects
     * @return a list of project preferences
     */
    public Set <Project> getPreferences() {
        return preferences;
    }

    /**
     * Add the projects to the list of project preferences
     * @param projects
     */
    public void setPreferences(Project ... projects) {
        preferences.addAll(Arrays.asList(projects));
    }

    @Override
    public String toString() {
        return "Student{" +
                "preferences=" + preferences +
                '}';
    }
}

