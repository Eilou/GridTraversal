package main.java;

import main.java.GUI.GUIFrame;

public class App {
    public static void main (String[] arg) {
        int rows = 10;
        int columns = 10;

        Grid grid = new Grid(rows, columns);
        System.out.println(grid);

        GridNode startNode = grid.getNodeByCoords(0,0);
        GridNode goalNode = grid.getNodeByCoords(8, 7);

        int delay = 100;
        Search search = new Search(grid, startNode, goalNode, "BFS", delay);

        GUIFrame guiFrame = new GUIFrame(search);

        search.setGUIFrame(guiFrame);
        if (search.runSearch())
            System.out.println("Goal has been found");
        else
            System.out.println("Goal has not been found");


    }
}