package main.java;

public class GridNode {

    private int x;
    private int y;
    private GridState state;

    /**
     * An element inside the grid
     *
     * @param x x coordinate of the node
     * @param y y coordinate of the node
     * @param state the cost of the node
     */
    public GridNode(int x, int y, GridState state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    /**
     * returns the total cost at that node
     * @return the total cost at that node
     */
    @Override
    public String toString() {
        return String.valueOf(state.getLocalCost() + state.getGlobalCost());
    }

}
