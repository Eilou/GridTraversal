package main.java;

public class GridNode {

    private int x;
    private int y;
    private GridState state;

    public GridNode(int x, int y, GridState state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.valueOf(state.getLocalCost() + state.getGlobalCost());
    }

}
