package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Search {

    private Grid grid;
    private ArrayList<GridNode> openList;
    private ArrayList<GridNode> closedList;
    private GridNode startNode;
    private GridNode goalNode;
    private GridNode currentNode;
    private String strategy;

    /**
     * Runs the search on a given grid, starting at the supplied node and ending at the specified
     * goal
     *
     * @param grid      grid of nodes to search through
     * @param startNode the node to start at
     * @param goalNode  the node to end on
     * @param strategy  the strategy to run
     */
    public Search(Grid grid, GridNode startNode, GridNode goalNode, String strategy) {
        this.grid = grid;
        this.openList = new ArrayList<>();
        this.closedList = new ArrayList<>();
        this.startNode = startNode;
        this.currentNode = startNode;
        this.goalNode = goalNode;
        this.strategy = strategy;
    }

    /**
     * Runs the search algorithm
     *
     * @return true if found, false if not
     */
    public boolean runSearch() {

        openList.add(startNode);
        while (!openList.isEmpty()) {
            expand();
            System.out.println("Iteration again");
            System.out.println(grid);
        }

        return false;
    }

    /**
     * Goes through and adds surrounding nodes provided they exist on the board and they are not
     * on either the openQueue or the closedList
     */
    public void expand() {

        try {
            ArrayList<GridNode> succesors = getSuccessors();
            ArrayList<GridNode> vettedSuccessors = vetSuccessors(succesors);

            openList.addAll(vettedSuccessors);
            openList.remove(currentNode);
            closedList.add(currentNode);
            currentNode = pickNext(strategy);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Decides which node should be looked at next
     */
    public GridNode pickNext(String strategy) throws RuntimeException {

        switch (strategy) {
            case "BFS" -> {
                return bfs();
            }
            case "DFS" -> {
                return dfs();
            }
            case "Dijkstra" -> {
                return dijkstra();
            }
            default -> {
                throw new RuntimeException("Invalid strategy type");
            }
        }


    }

    /**
     * Gets a list of the successor nodes relative to the current node
     *
     * @return a list of successor nodes to add to the open list
     */
    public ArrayList<GridNode> getSuccessors() {
        // get the possible coordinates
        ArrayList<GridNode> successors = new ArrayList<>();
        int[][] newNodeCoords = new int[4][2];
        if (currentNode.getX() != grid.getRows()) {
            newNodeCoords[0] = new int[]{currentNode.getX() + 1, currentNode.getY()}; //right
            newNodeCoords[1] = new int[]{currentNode.getX(), currentNode.getY() + 1}; //bottom
            newNodeCoords[2] = new int[]{currentNode.getX() - 1, currentNode.getY()}; //left
            newNodeCoords[3] = new int[]{currentNode.getX(), currentNode.getY() - 1}; //top
        }

        // make sure coordinates are not out of bounds
        for (int[] coords : newNodeCoords) {
            if (coords[0] == -1 || coords[0] == grid.getColumns() || coords[1] == -1 ||
                    coords[1] == grid.getRows())
                continue;
            GridNode nodeToAdd = grid.getNodeByCoords(coords[0], coords[1]);
            nodeToAdd.setParent(currentNode);
            successors.add(nodeToAdd);
        }

        return successors;

    }

    /**
     * Ensures the nodes to be added are not onthe
     *
     * @param unvettedSuccessors
     * @return
     */
    public ArrayList<GridNode> vetSuccessors(ArrayList<GridNode> unvettedSuccessors) {
        ArrayList<GridNode> vettedSuccessors = new ArrayList<>();
        for (GridNode gridNode : unvettedSuccessors) {
            boolean canAdd = true;
            canAdd = !openList.contains(gridNode);
            if (canAdd)
                canAdd = !closedList.contains(gridNode);
            if (canAdd) {
//                int xSteps = Math.abs(currentNode.getX() - startNode.getX());
//                int ySteps = Math.abs(currentNode.getY() - startNode.getY());
//                gridNode.setState(xSteps+ySteps + 1);
//                gridNode.setState(currentNode.getState().getLocalCost() + 1);
                gridNode.setState(gridNode.getParent().getState().getLocalCost() + 1);
                vettedSuccessors.add(gridNode);
            }
        }
        return vettedSuccessors;
    }

    public GridNode bfs() {
        return openList.get(0);
    }

    public GridNode dfs() {
        return openList.get(openList.size() - 1);
    }

    public GridNode dijkstra() {
        return openList.get(0);
    }

    public GridNode getStartNode() {
        return startNode;
    }

    public void setStartNode(GridNode startNode) {
        this.startNode = startNode;
    }

    public GridNode getGoalNode() {
        return goalNode;
    }

    public void setGoalNode(GridNode goalNode) {
        this.goalNode = goalNode;
    }

    public GridNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(GridNode currentNode) {
        this.currentNode = currentNode;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
