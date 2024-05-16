package main.java;

public class App {
    public static void main (String[] arg) {
        int rows = 10;
        int columns = 10;

        Grid grid = new Grid(rows, columns);
        System.out.println(grid);

        Search search = new Search(grid, grid.getNodeByCoords(0,0), grid.getNodeByCoords(rows-1,
                columns-1), "BFS");
        search.runSearch();


    }
}