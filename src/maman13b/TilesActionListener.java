/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author elira
 */
public class TilesActionListener implements ActionListener {
    private final int INVALID_TEXTFIELD_VALUE = 0;
    private ArrayList<TileTextField> tiles;
    
    /**
     * Empty constructor
     */
    public TilesActionListener() {
        tiles = new ArrayList<>();
    }
    
    /**
     * Constructor
     * @param tiles 
     */
    public TilesActionListener(ArrayList<TileTextField> tiles) {
        this.tiles = tiles;
    }
    
    /**
     * Get tiles
     * @return Array list of tiles
     */
    public ArrayList<TileTextField> getTiles() {
        return this.tiles;
    }
    
    /**
     * Set tiles
     * @param tiles Array list of tiles
     */
    public void setTiles(ArrayList<TileTextField> tiles) {
        this.tiles = tiles;
    }
    
    /**
     * Add tile to the listener
     * @param tile 
     */
    public void addTile(TileTextField tile) {
        this.tiles.add(tile);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Validate event
        if(e == null) return;
        Object source = e.getSource();
        if(!(source instanceof TileTextField)) return;
        
        // Validate input value
        TileTextField tile = (TileTextField) source;
        if(!validateTile(tile)) {
            tile.clearTile();
            JOptionPane.showMessageDialog(tile, "Set invalid tile value!");
        }
    }
    
    /**
     * Validate tile
     * @param tile
     * @return The argument value in valid (1-9 number), INVALID_TEXTFIELD_VALUE otherwise
     */
    private boolean validateTile(TileTextField tile) {
        // Validate tile row & column
        return validateTileValue(tile.getText()) &&
                validateTileRow(tile) &&
                validateTileColumn(tile);
    }
    
    /**
     * Validate tile value
     * @param value text field value
     * @return The argument value in valid (1-9 number), INVALID_TEXTFIELD_VALUE otherwise
     */
    private boolean validateTileValue(String value) {
        return value.length() == 1 && Character.isDigit(value.charAt(0));
    }
    
    private boolean validateTileRow(TileTextField tile) {
        for(TileTextField tileInMatrix : tiles) {
            // If there is a tile in the row (which is not the changed tile)
            // and its value equals the changed value, return false
            if(!tile.equals(tileInMatrix) && tile.getRow() == tileInMatrix.getRow()
                    && tile.getText().equals(tileInMatrix.getText())) {
                return false;
            }
        }
        
        // No tiles have the same value in the row
        return true;
    }
    
    private boolean validateTileColumn(TileTextField tile) {
        for(TileTextField tileInMatrix : tiles) {
            // If there is a tile in the row (which is not the changed tile)
            // and its value equals the changed value, return false
            if(!tile.equals(tileInMatrix) && tile.getColumn() == tileInMatrix.getColumn()
                    && tile.getText().equals(tileInMatrix.getText())) {
                return false;
            }
        }
        
        // No tiles have the same value in the row
        return true;
    }
}
