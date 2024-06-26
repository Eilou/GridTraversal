package main.java;

import java.util.ArrayList;

import main.java.GUI.*;

public class Search {

    private Grid grid;
    private ArrayList<GridNode> openList;
    private ArrayList<GridNode> closedList;
    private ArrayList<GridNode> parentList;
    private GridNode startNode;
    private GridNode goalNode;
    private GridNode currentNode;
    private Searches strategy;
    private GUIFrame guiFrame;
    private int delay;

    /**
     * Runs the search on a given grid, starting at the supplied node and ending at the specified
     * goal
     *
     * @param grid      grid of nodes to search through
     * @param startNode the node to start at
     * @param goalNode  the node to end on
     * @param strategy  the strategy to run
     * @param delay     the delay between each iteration
     */
    public Search(Grid grid, GridNode startNode, GridNode goalNode, Searches strategy, int delay) {
        this.grid = grid;
        this.openList = new ArrayList<>();
        this.closedList = new ArrayList<>();
        this.startNode = startNode;
        this.currentNode = startNode;
        this.goalNode = goalNode;
        this.strategy = strategy;
        this.delay = delay;
        this.parentList = new ArrayList<>();
    }

    /**
     * Runs the search algorithm
     *
     * @return true if found, false if not
     */
    public boolean runSearch() throws InterruptedException{

        openList.add(startNode);
        while (!openList.isEmpty()) {
            guiFrame.repaint();
            if (isGoal()) {
                runTraceback();
                return true;
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException ie) {
                System.out.println("An interrupt has occurred");
                System.out.println(ie.getMessage());
            }

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
    public GridNode pickNext(Searches strategy) throws RuntimeException {

        switch (strategy) {
            case BFS -> {
                return bfs();
            }
            case DFS -> {
                return dfs();
            }
            case DIJKSTRA -> {
                return dijkstra();
            }
            default -> throw new RuntimeException("Invalid strategy type");
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
            if (nodeToAdd.getParent() == null && nodeToAdd != startNode)
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

    public void runTraceback() {
        StringBuilder parentPath = new StringBuilder("Parent path: ");
        while (currentNode.getParent() != null) {
            guiFrame.getDrawingPanel().setMode("Traceback");
            guiFrame.repaint();
            parentPath.append("[");
            parentPath.append(currentNode.getX());
            parentPath.append(", ");
            parentPath.append(currentNode.getY());
            parentPath.append("]");
            parentPath.append(", ");
            parentList.add(0, currentNode);
            currentNode = currentNode.getParent();
        }
        parentPath.append("[");
        parentPath.append(currentNode.getX());
        parentPath.append(", ");
        parentPath.append(currentNode.getY());
        parentPath.append("]");
        parentPath.append(", ");
        parentList.add(0, currentNode);

        parentPath.setLength(parentPath.length()-2);
        System.out.println(parentPath);
    }

    /**
     * resets the instance variables of each search
     */
    public void initialise() {

        openList = new ArrayList<>();
        closedList = new ArrayList<>();
        parentList = new ArrayList<>();
        for (GridNode[] gridRow : grid.getGrid())
            for (GridNode gridColumn : gridRow)
                gridColumn.setParent(null);

    }

    public boolean isGoal() {
        return currentNode == goalNode;
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

    public Grid getGrid() {
        return grid;
    }

    public ArrayList<GridNode> getOpenList() {
        return openList;
    }

    public ArrayList<GridNode> getClosedList() {
        return closedList;
    }

    public void setGUIFrame(GUIFrame guiFrame) {
        this.guiFrame = guiFrame;
    }

    public ArrayList<GridNode> getParentList() {
        return this.parentList;
    }

    public Searches getStrategy() {
        return strategy;
    }

    public void setStrategy(Searches strategy) {
        this.strategy = strategy;
    }

}
