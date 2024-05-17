package main.java;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public class GridNode {

    private int x;
    private int y;
    private GridNode parent;
    private GridState state;

    /**
     * An element inside the grid
     *
     * @param x     x coordinate of the node
     * @param y     y coordinate of the node
     * @param state the cost of the node
     */
    public GridNode(int x, int y, GridState state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    /**
     * returns the total cost at that node
     *
     * @return the total cost at that node
     */
    @Override
    public String toString() {
        return String.valueOf(state.getLocalCost() + state.getGlobalCost());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GridState getState() {
        return state;
    }

    public void setState(GridState state) {
        this.state = state;
    }

    /**
     * Sets the local cost of a grid node by relaying it to the state
     *
     * @param localCost local cost of the grid node relative to the start
     */
    public void setState(int localCost) {
        this.state.setLocalCost(localCost);
    }

    public GridNode getParent() {
        return parent;
    }

    public void setParent(GridNode parent) {
        this.parent = parent;
    }
}
