package main.java.GUI;

import javax.swing.*;
import java.awt.*;

import main.java.GUI.handlers.StartSearchHandler;
import main.java.Search;
import main.java.Searches;
import main.java.helperGUI.*;

public class ButtonPanel extends JPanel {

    private Scaling scaling;
    private Dimension parentPanelSize;
    private JButton dijkstraButton;
    private JButton dfsButton;
    private JButton bfsButton;

    public ButtonPanel(Dimension parentPanelSize) {
        this.parentPanelSize = parentPanelSize;
        scaling = new Scaling(this.parentPanelSize);
        setBackground(Color.green);
        setPreferredSize(new Dimension(scaling.scaledX(0.25), scaling.scaledY(1)));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        dijkstraButton = new JButton("Dijkstra's");

        dfsButton = new JButton("DFS");
        bfsButton = new JButton("BFS");
        addButtons();
    }

    public void addButtons() {
        add(dijkstraButton);
        add(dfsButton);
        add(bfsButton);
    }

    /**
     * Attach the handlers to the buttons to run the searches
     *
     * @param search the search algorithm class to then be ran
     */
    public void attachHandlers(Search search) {
        dijkstraButton.addActionListener(new StartSearchHandler(search, Searches.DIJKSTRA));
        dfsButton.addActionListener(new StartSearchHandler(search, Searches.DFS));
        bfsButton.addActionListener(new StartSearchHandler(search, Searches.BFS));
    }

}
