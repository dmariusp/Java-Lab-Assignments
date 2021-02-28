package compulsory;

import java.util.Arrays;

public class Source {

    /**
     * getter and setter for the type of the Source
     *
     * @return type
     */
    public SourceType getSourceType() {
        return type;
    }

    public void setSourceType(SourceType type) {
        this.type = type;
    }

    private SourceType type;

    /**
     * getter and setter for the name of the Source
     *
     * @return names
     */
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    private String names;

    /**
     * default constructor
     */
    public Source() {
    }

    /**
     * initializer constructor which initializes all private members of the Source class
     */
    public Source(String names, SourceType type) {
        this.names = names;
        this.type = type;
    }

    /**
     * method to override the toString() method from Object class
     */
    public String toString() {
        return "Source{" +
                "SourceType=" + type +
                ", names='" + names + '\'' +
                '}';
    }

}
