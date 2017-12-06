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
    private ArrayList<Tile> tiles;
    
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
    public TilesActionListener(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }
    
    /**
     * Get tiles
     * @return Array list of tiles
     */
    public ArrayList<Tile> getTiles() {
        return this.tiles;
    }
    
    /**
     * Set tiles
     * @param tiles Array list of tiles
     */
    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Validate event
        if(e == null) return;
        Object source = e.getSource();
        if(!(source instanceof TileTextField)) return;
        
        // Validate input value
        TileTextField tile = (TileTextField) source;
        int value = validateTile(tile);
        if(value != INVALID_TEXTFIELD_VALUE) {
            tile.getTile().setValue(value); // Set tile if valid
        }
        else {
            tile.setText(Integer.toString(value)); // Restore value if invalid
            JOptionPane.showMessageDialog(tile, "Set invalid tile value!");
        }
    }
    
    /**
     * Validate tile
     * @param textTile
     * @return The argument value in valid (1-9 number), INVALID_TEXTFIELD_VALUE otherwise
     */
    private int validateTile(TileTextField textTile) {
        // Validate tile value
        int value = validateTileValue(textTile.getText());
        if(value == INVALID_TEXTFIELD_VALUE) {
            return INVALID_TEXTFIELD_VALUE;
        }
        
        // Validate tile row & column
        return validateTileRow(value, textTile.getTile()) &&
                validateTileColumn(value, textTile.getTile()) ?
                value
                : INVALID_TEXTFIELD_VALUE;
    }
    
    /**
     * Validate tile value
     * @param text text field's text
     * @return The argument value in valid (1-9 number), INVALID_TEXTFIELD_VALUE otherwise
     */
    private int validateTileValue(String text) {
        try {
            int value = Integer.parseInt(text);
            if(value > 0 && value < 10) {
                return value;
            }
            else {
                return INVALID_TEXTFIELD_VALUE;
            }
        }
        catch(NumberFormatException e) {
            return INVALID_TEXTFIELD_VALUE;
        }
    }
    
    /**
     * Validate tile's row
     * @param value tile's potential value
     * @param tile tile
     * @return true if tile is valid, false otherwise
     */
    private boolean validateTileRow(int value, Tile tile) {
        for(Tile tileInMatrix : tiles) {
            // If there is a tile in the row (which is not the changed tile)
            // and its value equals the changed value, return false
            if(!tile.equals(tileInMatrix) && tile.getRow() == tileInMatrix.getRow()
                    && value == tileInMatrix.getValue()) {
                return false;
            }
        }
        
        // No tiles have the same value in the row
        return true;
    }
    
    /**
     * Validate tile's column
     * @param value tile's potential value
     * @param tile tile
     * @return true if tile is valid, false otherwise
     */
    private boolean validateTileColumn(int value, Tile tile) {
        for(Tile tileInMatrix : tiles) {
            // If there is a tile in the column (which is not the changed tile)
            // and its value equals the changed value, return false
            if(!tile.equals(tileInMatrix) && tile.getColumn()== tileInMatrix.getColumn()
                    && value == tileInMatrix.getValue()) {
                return false;
            }
        }
        
        // No tiles have the same value in the column
        return true;
    }
}
