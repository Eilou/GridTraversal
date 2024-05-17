package main.java.GUI;

import main.java.*;
import main.java.helperGUI.Scaling;

import javax.swing.*;
import java.awt.*;


public class DrawingPanel extends JPanel {

    private Scaling scaling;
    private Dimension parentPanelSize;
    private Search search;
    private Graphics2D g2d;

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
        drawGridLines();
//        drawStartNode();
//        drawGoalNode();
    }

    public void drawGridLines() {
        Grid grid = search.getGrid();

        int cellWidth = (int) Math.round(getSize().getWidth()/grid.getColumns());
        int cellHeight = (int) Math.round(getSize().getHeight()/grid.getRows());

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);

        for (int row = 0; row < grid.getRows(); row++)
            g2d.drawLine(0, row * cellHeight, getSize().width, row * cellHeight);

        for (int column = 0; column < grid.getColumns(); column++)
            g2d.drawLine(column * cellWidth, 0, column * cellWidth,getSize().height);

//            for (int column = 0; column < grid.getColumns(); column++) {
//
//                g2d.drawLine(column * cellWidth, );
//
//            }
//        }
    }


}
