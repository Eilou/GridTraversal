package main.java;

public class Grid {

    private int rows;
    private int columns;
    private GridNode[][] grid;

    /**
     * Builds the grid
     *
     * @param rows    rows in the grid
     * @param columns columns in the grid
     */
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new GridNode[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                grid[i][j] = new GridNode(i, j, new GridState());
    }

    /**
     * Gets a pointer to a node in the grid
     *
     * @param x x coordinate of node
     * @param y y coordinate of node
     * @return the node
     * @throws NullPointerException if the node does not exist
     */
    public GridNode getNodeByCoords(int x, int y) throws NullPointerException {
        if (grid[x][y] == null)
            throw new NullPointerException("Grid node does not exist");
        else
            return grid[x][y];
    }

    /**
     * Formatted cli version of the grid
     *
     * @return the current state of the grid
     */
    @Override
    public String toString() {
        StringBuilder gridOutput = new StringBuilder();
        gridOutput.append("  ");
        gridOutput.append("-".repeat(Math.max(0, (columns * 2) + 3)));
        gridOutput.append("\n    ");
        for (int i = 0; i < columns; i++)
            gridOutput.append(i + " ");
        gridOutput.append("\n    ");
        gridOutput.append("-".repeat(Math.max(0, (columns * 2) + 3)));

        gridOutput.append("\n");
        for (int i = 0; i < rows; i++) {
            gridOutput.append(i + " | ");
            for (int j = 0; j < columns; j++) {
                gridOutput.append(grid[i][j]);
                gridOutput.append(" ");
            }
            gridOutput.append("|\n");
        }
        gridOutput.append("-".repeat(Math.max(0, (columns * 2) + 3)));

        return gridOutput.toString();

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public GridNode[][] getGrid() {
        return grid;
    }

    public void setGrid(GridNode[][] grid) {
        this.grid = grid;
    }
}
