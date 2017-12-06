/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13b;

/**
 *
 * @author elira
 */
public class Tile {
    private int value;
    private int row;
    private int column;
    
    /**
     * Empty constructor
     */
    public Tile() {
        value = row = column = 0;
    }
    
    /**
     * Constructor
     * @param row Tile row number
     * @param column Tile column number
     */
    public Tile(int row, int column) {
        this();
        this.row = row;
        this.column = column;
    }
    
    /**
     * Constructor
     * @param number Tile value
     * @param row Tile row
     * @param column Tile column
     */
    public Tile(int number, int row, int column) {
        this(row, column);
        this.value = number;
    }
    
    /**
     * Get the tile value
     * @return int value
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Get the tile row number
     * @return int row number
     */
    public int getRow() {
        return this.row;
    }
    
    /**
     * Get the tile column number
     * @return int column number
     */
    public int getColumn() {
        return this.column;
    }
    
    /**
     * Set the tile value
     * @param value int value
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Set the tile row
     * @param row int row
     */
    public void setRow(int row) {
        this.row = row;
    }
    
    /**
     * Set the tile column
     * @param column int column
     */
    public void setColumn(int column) {
        this.column = column;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Tile)) return false;
        
        Tile tile = (Tile) obj;
        return this.value == tile.getValue() && this.row == tile.getRow() && 
                this.column == tile.getColumn();
    }
}
