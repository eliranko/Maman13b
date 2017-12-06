/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13b;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author elira
 */
public class SudokuPanel extends JPanel {
    private int numberOfRows;
    private int numberOfColumns;
    private Color immutableTileColor;
    private Color mutableTileColor;
    
    /**
     * Empty constructor
     */
    public SudokuPanel() {
        this.numberOfColumns = 0;
        this.numberOfRows = 0;
        this.immutableTileColor = Color.GRAY;
        this.mutableTileColor = Color.WHITE;
    }
    
    /**
     * Constructor
     * @param numberOfRows number of rows
     * @param numberOfColumns number of columns
     */
    public SudokuPanel(int numberOfRows, int numberOfColumns) {
        this();
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }
    
    /**
     * Constructor
     * @param numberOfRows number of rows
     * @param numberOfColumns number of columns
     * @param immutableTileColor immutable tile color
     * @param mutableTileColor mutable tile color
     */
    public SudokuPanel(int numberOfRows, int numberOfColumns,
            Color immutableTileColor, Color mutableTileColor) {
        this(numberOfRows, numberOfColumns);
        this.immutableTileColor = immutableTileColor;
        this.mutableTileColor = mutableTileColor;
    }

    /**
     * Get the number of rows
     * @return int
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Get the number of columns
     * @return int
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Get immutable tile color
     * @return Color
     */
    public Color getImmutableTileColor() {
        return immutableTileColor;
    }

    /**
     * Get mutable tile color
     * @return Color
     */
    public Color getMutableTileColor() {
        return mutableTileColor;
    }

    /**
     * Set number of rows
     * @param numberOfRows number of rows
     */
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    /**
     * Set number of columns
     * @param numberOfColumns number of columns
     */
    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Set immutable tile color
     * @param immutableTileColor immutable tile color
     */
    public void setImmutableTileColor(Color immutableTileColor) {
        this.immutableTileColor = immutableTileColor;
    }

    /**
     * Set mutable tile color
     * @param mutableTileColor 
     */
    public void setMutableTileColor(Color mutableTileColor) {
        this.mutableTileColor = mutableTileColor;
    }
    
    
}
