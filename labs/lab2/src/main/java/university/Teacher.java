/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Teacher extends Person {
    private Set<Student> preferences;

    /**
     * Constructor with arguments
     * @param name a string representing the name of the teacher
     * @param email a string representing the personal email
     */
    public Teacher(String name, String email) {
        /**
         * Invokes the constructor from the superclass
         */
        super(name, email);

        this.preferences = new HashSet <>();
    }

    /**
     * Creates and assigns a project
     * @param capacity
     * @param name
     */
    public Project createProject(String name, int capacity) {
        return new Project(name, capacity);
    }

    /**
     * Add the students to the list of student preferences
     * @param students the students to be added
     */
    public void setPreferences(Student ... students) {
        preferences.addAll(Arrays.asList(students));
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "preferences=" + preferences +
                '}';
    }

    public Set <Student> getPreferences() {
        return preferences;
    }
}