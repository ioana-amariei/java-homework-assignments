/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.lang.reflect.Array;
import java.util.*;

public class Problem {
    private Set<Student> students;
    private Set<Teacher> teachers;

    /**
     * Default constructor
     */
    public Problem() {
        students = new HashSet <>();
        teachers = new HashSet <>();
    }

    /**
     * Sets the students set
     * @param students
     */
    public void setStudents(Student ... students) {
        this.students.addAll(Arrays.asList(students));
    }

    /**
     * Sets the teachers set
     * @param teachers
     */
    public void setTeachers(Teacher ... teachers) {
        this.teachers.addAll(Arrays.asList(teachers));
    }

    /**
     * Gets all the participants (students and theachers) involved
     * @return an array of all the students and theachers involved
     */
    public Person[] getParticipants(){
        List<Person> participants = new ArrayList <>();
        participants.addAll(students);
        participants.addAll(teachers);

        Person[] persons = new Person[participants.size()];

        return participants.toArray(persons);
    }

    /**
     * Gets the set of students involved
     * @return a set of students
     */
    public Set <Student> getStudents() {

        return students;
    }

    /**
     * Gets the set of teachers involved
     * @return a set of teachers
     */
    public Set <Teacher> getTeachers() {

        return teachers;
    }


    @Override
    public String toString() {
        return "Problem{" +
                "students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
