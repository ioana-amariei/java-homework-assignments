/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Person {
    private List<Student> preferences;
    private Project project;

    /**
     * Constructor with arguments
     * @param name a string representing the name of the teacher
     * @param email a string representing the personal email
     */
    public Teacher(String name, String email) {
        super(name, email);

        this.preferences = new ArrayList <Student>();
        this.project = new Project(null, 0);
    }

    /**
     * Gets the project
     * @return a Project object
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the project
     * @param project project to be set
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Add a student to the list of preferences of the teacher
     * @param student the student to be added
     */
    public void setPreferences(Student student) {
        preferences.add(student);
    }

    /**
     * Creates and assigns a project
     * @param capacity
     * @param name
     */
    public Project createProject(String name, int capacity) {
        this.project = new Project(name, capacity);
        return this.project;
    }

    /**
     * Add 4 students to the list of student preferences
     * @param students
     */
    public void setPreferences(Student ... students) {
        preferences.addAll(Arrays.asList(students));
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "preferences=" + preferences +
                ", project=" + project +
                '}';
    }
}