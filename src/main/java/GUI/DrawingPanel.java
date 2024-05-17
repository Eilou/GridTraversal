package main.java.GUI;

import main.java.*;
import main.java.helperGUI.Scaling;

import javax.swing.*;
import java.awt.*;


public class DrawingPanel extends JPanel {

    private Scaling scaling;
    private Dimension parentPanelSize;
    private Search search;

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
        Graphics2D g2d = (Graphics2D) g;

        setup();
        drawGridLines();
    }

    public void setup() {
        setBackground(Color.white);
    }

    public void drawGridLines() {

    }


}
