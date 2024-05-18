package main.java.GUI.handlers;

import main.java.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartSearchHandler implements ActionListener {

    private Search search;
    private Searches searchType;

    /**
     * Creates the action listener
     * @param search
     * @param searchType
     */
    public StartSearchHandler(Search search, Searches searchType) {
        this.search = search;
        this.searchType = searchType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        search.setStrategy(searchType);
        search.initialise();
        if (search.runSearch())
            System.out.println("Goal has been found");
        else
            System.out.println("Goal has not been found");
    }
}
