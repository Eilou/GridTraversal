package main.java;

public class GridState {

    private int localCost;
    private int globalCost;

    /**
     * Creates a given item with initially no cost
     */
    public GridState() {
        this(0,0);
    }

    /**
     * One parameter used to specify just the local cost
     *
     * @param localCost local cost of the node
     */
    public GridState(int localCost) {
        this(localCost, 0);
    }

    /**
     * Use both parameters to specify both local and global
     *
     * @param localCost local cost of the node
     * @param globalCost global cost of the node
     */
    public GridState(int localCost, int globalCost) {
        this.localCost = localCost;
        this.globalCost = globalCost;
    }

    public int getGlobalCost() {
        return globalCost;
    }

    public void setGlobalCost(int globalCost) {
        this.globalCost = globalCost;
    }

    public int getLocalCost() {
        return localCost;
    }

    public void setLocalCost(int localCost) {
        this.localCost = localCost;
    }
}
