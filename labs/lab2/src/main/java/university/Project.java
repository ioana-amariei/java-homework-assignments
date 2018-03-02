/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;

public class Project {
    private String name;
    private int capacity;

    /**
     * Constructor with arguments
     * @param name a string value representing the name of the project
     * @param capacity an int value representing the capacity constraint
     *                 (an upper bound regarding how many students can be enrolled)
     */
    public Project(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
    }

    /**
     * Gets the capacity
     * @return the capacity constraint (int value)
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity
     * @param capacity the capacity to be set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the project name
     * @return a string representing the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

