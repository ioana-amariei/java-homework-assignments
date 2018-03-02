/**
 * @author Birsan Ioana (cas. Amariei), B5
 * @author Gensthaler Octavian, B5
 */

package university;

public class Person {
    private String name;
    private String email;

    /**
     * Constructor with arguments
     * @param name a string representing the name of the person
     * @param email a string representing the personal email
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Default constructor
     */
    public Person() {
    }

    /**
     * Gets the name
     * @return a string representing the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name the name to be set (string value)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email
     * @return the email (string value)
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * @param email a string representing the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return email != null ? email.equals(person.email) : person.email == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
