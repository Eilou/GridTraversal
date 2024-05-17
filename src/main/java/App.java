package main.java;

import main.java.GUI.GUIFrame;

public class App {
    public static void main (String[] arg) {
        int rows = 10;
        int columns = 10;

        Grid grid = new Grid(rows, columns);
        System.out.println(grid);

        GridNode startNode = grid.getNodeByCoords(0,0);
        GridNode goalNode = grid.getNodeByCoords(rows-1, columns-1);

        Search search = new Search(grid, startNode, goalNode, "DFS");

        GUIFrame guiFrame = new GUIFrame(search);

        search.runSearch();

    }
}