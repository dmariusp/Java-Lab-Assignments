package compulsory;

import java.util.Arrays;


public class Problem {
    private Source[] sources;
    private Destination[] destinations;

    private int[] supply;
    private int[] demands;
    private int costMatrix[][];

    /**
     * default constructor
     */
    public Problem() {

    }

    /**
     * initializer constructor which initializes all private members of the Problem class
     */
    public Problem(Source[] sources, Destination[] destinations, int[] supply, int[] demands, int[][] costMatrix) {
        this.sources = sources;
        this.destinations = destinations;
        this.supply = supply;
        this.demands = demands;
        this.costMatrix = costMatrix;
    }

    /**
     * getter and setter for the array of sources
     *
     * @return sources
     */
    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    /**
     * getter and setter for the array of destinations
     *
     * @return destinations
     */
    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    /**
     * getter and setter for array of supply to know how much capacity can every source offer
     *
     * @return array supply
     */
    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    /**
     * getter and setter of array of demands to know every destination how much they want
     *
     * @return array of demands
     */
    public int[] getDemands() {
        return demands;
    }

    public void setDemands(int[] demands) {
        this.demands = demands;
    }

    /**
     * getter and setter for the cost Matrix in which is stores units of commodities from source to destination
     *
     * @return the cost Matrix
     */
    public int[][] getCostMatrix() {
        return costMatrix;
    }

    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }

    /**
     * method to override the toString() method from Object class
     */
    @Override
    public String toString() {
        return "Problem{" +
                "\n sources=" + Arrays.toString(sources) +
                "\n destinations=" + Arrays.toString(destinations) +
                "\n supply=" + Arrays.toString(supply) +
                "\n demands=" + Arrays.toString(demands) +
                "\n costMatrix=" + Arrays.deepToString(costMatrix) +
                "\n }";
    }
}
