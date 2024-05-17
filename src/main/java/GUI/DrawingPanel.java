package main.java.GUI;

import main.java.*;
import main.java.helperGUI.Scaling;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class DrawingPanel extends JPanel {

    private Scaling scaling;
    private Dimension parentPanelSize;
    private Search search;
    private Graphics2D g2d;

    private Dimension cell;

    /**
     * Sets up the panel and gives it access to the search data
     *
     * @param parentPanelSize size of the frame
     * @param search          searching algorithm
     */
    public DrawingPanel(Dimension parentPanelSize, Search search) {
        this.parentPanelSize = parentPanelSize;
        scaling = new Scaling(parentPanelSize);
        this.search = search;
        setBackground(Color.white);
        setPreferredSize(new Dimension(scaling.scaledX(0.75), scaling.scaledY(1)));
    }

    /**
     * Draws the grid and updates as the search is ran
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        this.g2d = (Graphics2D) g;

        setup();
    }

    public void setup() {
        setBackground(Color.white);
        Grid grid = search.getGrid();
        cell = new Dimension((int) Math.round(getSize().getWidth()/grid.getColumns()),
                (int) Math.round(getSize().getHeight()/grid.getRows()));
        drawOpenAndClose();
        drawStartNode();
        drawGoalNode();
        drawCurrentNode();
        drawGridLines();
    }

    /**
     * Draw the grid on the background
     */
    public void drawGridLines() {
        Grid grid = search.getGrid();

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);

        for (int row = 0; row < grid.getRows(); row++)
            g2d.drawLine(0, row * cell.height, getSize().width, row * cell.height);

        for (int column = 0; column < grid.getColumns(); column++)
            g2d.drawLine(column * cell.width, 0, column * cell.width,getSize().height);
    }

    /**
     * Colours in the starting node as purple
     */
    public void drawStartNode() {
        GridNode startNode = search.getStartNode();
        g2d.setColor(new Color(255, 0, 255));
        g2d.fillRect(startNode.getX() * cell.width, startNode.getY() * cell.height, cell.width,
                cell.height);
    }

    /**
     * Colours in the goal node as green
     */
    public void drawGoalNode() {
        GridNode goalNode = search.getGoalNode();
        g2d.setColor(new Color(0, 255, 0));
        g2d.fillRect(goalNode.getX() * cell.width, goalNode.getY() * cell.height, cell.width,
                cell.height);
    }

    /**
     * Updates the grid corresponding to whether nodes are on the open or the closed list
     */
    public void drawOpenAndClose() {
        ArrayList<GridNode> openList = search.getOpenList();
        ArrayList<GridNode> closedList = search.getClosedList();

        for (GridNode openNode : openList) {
            g2d.setColor(new Color(255, 255, 0));
            g2d.fillRect(openNode.getX() * cell.width, openNode.getY() * cell.height,
                    cell.width, cell.height);
        }

        for (GridNode closedNode : closedList) {
            g2d.setColor(new Color(94, 94, 94));
            g2d.fillRect(closedNode.getX() * cell.width, closedNode.getY() * cell.height,
                    cell.width, cell.height);
        }

    }

    public void drawCurrentNode() {
        GridNode currentNode = search.getCurrentNode();
        g2d.setColor(new Color(255, 0, 0));
        g2d.fillRect(currentNode.getX() * cell.width, currentNode.getY() * cell.height, cell.width,
                cell.height);
    }



}
