package main.java;

public class GridState {

    private int localCost;
    private int globalCost;

    public GridState() {
        this.localCost = 0;
        this.globalCost = 0;
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
