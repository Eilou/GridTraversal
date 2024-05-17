package main.java.GUI;

import javax.swing.*;
import java.awt.*;

import main.java.*;

public class GUIFrame extends JFrame {

    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
    public Dimension screenSize = toolkit.getScreenSize();

    /**
     * Set up the parent frame to draw the GUI
     */
    public GUIFrame(Search search) {
        setTitle("Different branch paths");
        setSize((int) Math.round(screenSize.width * 0.5),
                (int) Math.round(screenSize.height * 0.5));
        setupPanels(search);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void setupPanels(Search search) {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        ButtonPanel buttonPanel = new ButtonPanel(this.getSize());


        contentPane.add(buttonPanel, BorderLayout.EAST);

        DrawingPanel drawingPanel = new DrawingPanel(this.getSize(), search);


        contentPane.add(drawingPanel, BorderLayout.CENTER);


    }

}
