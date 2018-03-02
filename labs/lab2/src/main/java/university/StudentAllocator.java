/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;

import java.util.*;

public class StudentAllocator {
    private Map <String, String> matches;
    private Problem problem;

    /**
     * Constructor with arguments
     *
     * @param problem a Problem object representing the problem to be solved
     */
    public StudentAllocator(Problem problem) {
        matches = new HashMap <>();
        this.problem = problem;
    }

    public void matchStudentToProject() {
        Set <Student> students = problem.getStudents();
        Set <Teacher> teachers = problem.getTeachers();
        Set <Project> projects = new HashSet <>();

        for (Student student : students) {
            projects.addAll(student.getPreferences());
        }

        for (Student student : students) {
            Set <Project> studentPreferences = student.getPreferences();
            studentPreferences = updateStudentPreferences(projects, studentPreferences);

            for (Teacher teacher : teachers) {
                Set <Student> teacherPreferences = teacher.getPreferences();
                teacherPreferences = updateTeacherPreferences(students, teacherPreferences);

                if (teacherPreferences.contains(student)) {

                    Project project = studentPreferences.iterator().next();

                    // add the matching pair
                    matches.put(student.getName(), project.getName());

                    students.remove(student);
                    int newCapacity = project.getCapacity() - 1;
                    if (newCapacity == 0) {
                        projects.remove(project);
                    }
                }
            }
        }
    }

    private Set <Student> updateTeacherPreferences(Set <Student> students, Set <Student> teacherPreferences) {
        Set <Student> updatedList = new HashSet <>();

        while (!teacherPreferences.isEmpty()) {
            Student student = teacherPreferences.iterator().next();
            if (students.contains(student)) {
                updatedList.add(student);
                teacherPreferences.remove(student);
            }
        }

        return updatedList;
    }


    private Set <Project> updateStudentPreferences(Set <Project> projects, Set <Project> studentPreferences) {
        Set <Project> updatedList = new HashSet <>();

        while (!studentPreferences.isEmpty()) {
            Project project = studentPreferences.iterator().next();
            if (projects.contains(project)) {
                updatedList.add(project);
                studentPreferences.remove(project);
            }
        }

        return updatedList;
    }


    @Override
    public String toString() {
        return "StudentAllocator{" +
                "matches=" + matches +
                '}';
    }
}
