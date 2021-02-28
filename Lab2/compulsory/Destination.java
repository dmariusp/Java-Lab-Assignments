package compulsory;

public class Destination {

    /**
     * getter and setter for the name of the Destination
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    /**
     * default constructor
     */
    public Destination() {
    }

    /**
     * initializer constructor which initializes all private members of the Destination class
     */
    public Destination(String name) {
        this.name = name;

    }

    /**
     * method to override the toString() method from Object class
     */
    public String toString() {
        return "Destination{" +
                "names='" + name + '\'' +
                '}';
    }
}

