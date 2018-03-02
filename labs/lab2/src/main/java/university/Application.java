/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Student s1 = new Student("S1", "s1@info.uaic.ro");
        Student s2 = new Student("S2", "s2@info.uaic.ro");
        Student s3 = new Student("S3", "s3@info.uaic.ro");
        Student s4 = new Student("S4", "s4@info.uaic.ro");

        Teacher t1 = new Teacher("T1", "t1@info.uaic.ro");
        Project p1 = t1.createProject("P1", 2);

        Teacher t2 = new Teacher("T2", "t2@info.uaic.ro");
        Project p2 = t2.createProject("P2", 2);

        Teacher t3 = new Teacher("T3", "t3@info.uaic.ro");
        Project p3 = t3.createProject("P3", 2);

        s1.setPreferences(p1);
        s2.setPreferences(p1);
        s3.setPreferences(p1);
        s4.setPreferences(p3);

        t1.setPreferences(s3);
        t2.setPreferences(s1);
        t3.setPreferences(s4);

        Problem problem = new Problem();
        problem.setStudents(s1, s2, s3, s4);
        problem.setTeachers(t1, t2, t3);
        System.out.println(problem);

        Person[] persons = problem.getParticipants();
        System.out.println(Arrays.toString(persons));
    }
}
