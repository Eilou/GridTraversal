package main.java;

public class Grid {

    private int rows;
    private int columns;
    private GridNode[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new GridNode[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                grid[i][j] = new GridNode(i, j, new GridState());
    }

    @Override
    public String toString() {
        StringBuilder gridOutput = new StringBuilder();
        gridOutput.append("-".repeat(Math.max(0,(columns*2)+3)));
        gridOutput.append("\n");
        for (int i = 0; i < rows; i++) {
            gridOutput.append("| ");
            for (int j = 0; j < columns; j++) {
                gridOutput.append(grid[i][j]);
                gridOutput.append(" ");
            }
            gridOutput.append("|\n");
        }
        gridOutput.append("-".repeat(Math.max(0,(columns*2)+3)));

        return gridOutput.toString();

    }



}
