package main.java;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Search {

    private Grid grid;
    private PriorityQueue<GridNode> openQueue;
    private HashSet<GridNode> closedList;
    private GridNode startNode;
    private GridNode goalNode;

    /**
     * Runs the search on a given grid, starting at the supplied node and ending at the specified
     * goal
     *
     * @param grid grid of nodes to search through
     * @param startNode the node to start at
     * @param goalNode the node to end on
     */
    public Search(Grid grid, GridNode startNode, GridNode goalNode) {
        this.grid = grid;
        this.openQueue = new PriorityQueue<>();
        this.startNode = startNode;
        this.goalNode = goalNode;
    }

    /**
     * Runs the search algorithm
     *
     * @return true if found, false if not
     */
    public boolean runSearch() {

        GridNode currentNode = startNode;
        openQueue.add(startNode);
        while (!openQueue.isEmpty()) {
            currentNode = openQueue.poll();

            expand();

        }

        return false;
    }

    /**
     * Goes through and adds surrounding nodes provided they exist on the board and they are not
     * on either the openQueue or the closedList
     */
    public void expand() {

    }




}
