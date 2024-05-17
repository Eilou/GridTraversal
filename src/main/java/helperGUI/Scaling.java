package main.java.helperGUI;

import java.awt.*;

/**
 * Helps convert from one form of measurement to one used in GUIs
 */
public class Scaling {
    private Dimension area;
    public Scaling(Dimension area) {
        this.area = area;
    }

    /**
     * Takes a percentage width of the area and returns integer size
     * @param percentage value from 0 to 1
     * @return corresponding percentage of the area's width
     */
    public int scaledX(double percentage) {
        return (int) Math.round(area.getWidth() * percentage);
    }

    /**
     * Does the same as scaledX but relative to the area's height
     * @param percentage value from 0 to 1
     * @return corresponding percentage of area's height
     */
    public int scaledY(double percentage) {
        return (int) Math.round(area.getHeight() * percentage);
    }
}
