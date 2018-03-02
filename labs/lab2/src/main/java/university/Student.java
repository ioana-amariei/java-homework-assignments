/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person {
    private Project project;
    private List<Project> preferences;

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

        this.project = new Project(null, 0);
        this.preferences = new ArrayList <Project>();
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
     * @param project the project to be set
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets the list of preferred projects
     * @return a list of project preferences
     */
    public List <Project> getPreferences() {
        return preferences;
    }

    /**
     * Add 3 projects to the list of project preferences
     * @param projects
     */
    public void setPreferences(Project ... projects) {
        preferences.addAll(Arrays.asList(projects));
    }

    /**
     * Add a project to the list of project preferences
     * @param project the project to be added
     */
    public void setPreferences(Project project) {
        preferences.add(project);
    }



    @Override
    public String toString() {
        return "Student{" +
                "project=" + project +
                ", preferences=" + preferences +
                '}';
    }
}

