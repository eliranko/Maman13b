/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13b;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author elira
 */
public class TileTextField extends JTextField {
    private Tile tile;
    private Color immutableTileColor;
    private Color mutableTileColor;
    private TileTextFieldState tileTextFieldState;
    
    /**
     * Empty constructor.
     * Default immutable color is gray
     * Default mutable color is white
     * Default state is SETTING_IMMUTABLE_VALUE
     */
    public TileTextField() {
        this.tile = new Tile();
        setTile(this.tile);
        setTileTextFieldState(TileTextFieldState.SETTING_IMMUTABLE_VALUE);
        setImmutableTileColor(Color.GRAY);
        setMutableTileColor(Color.WHITE);   
    }
    
    /**
     * Constructor
     * @param listener Action listener object
     */
    public TileTextField(ActionListener listener) {
        this();
        addActionListener(listener);
    }
    
    /**
     * Constructor
     * @param tile Tile object
     * @param listener Action listener object
     */
    public TileTextField(Tile tile, ActionListener listener) {
        this(listener);
        this.tile = tile;
        setTile(this.tile);
    }
    
    /**
     * Constructor
     * @param tile Tile object
     * @param immutableTileColor Color of the immutable tiles
     * @param mutableTileColor Color of the mutable tiles
     * @param tileTextFieldState tile text field state
     * @param listener Action listener object
     */
    public TileTextField(Tile tile, Color immutableTileColor, 
            Color mutableTileColor, TileTextFieldState tileTextFieldState,
            ActionListener listener) {
        this(tile, listener);
        setImmutableTileColor(immutableTileColor);
        setMutableTileColor(mutableTileColor);
        this.tileTextFieldState = tileTextFieldState;
    }
    
    /**
     * Get the represented tile
     * @return Tile object
     */
    public Tile getTile() {
        return this.tile;
    }
    
    /**
     * Get immutable tile color
     * @return Color object
     */
    public Color getImmutableTileColor() {
        return this.immutableTileColor;
    }
    
    /**
     * Get mutable tile color
     * @return Color object
     */
    public Color getMutableTileColor() {
        return this.mutableTileColor;
    }
    
    /**
     * Get tile state
     * @return TileTextFieldState
     */
    public TileTextFieldState getTileTextFieldState() {
        return this.tileTextFieldState;
    }
    
    /**
     * Set the tile
     * @param tile Tile object
     */
    public void setTile(Tile tile) {
        this.tile = tile;
        setText(tile.getValue());
    }
    
    /**
     * Set the immutable tiles color
     * @param immutableTileColor Color object
     */
    public void setImmutableTileColor(Color immutableTileColor) {
        this.immutableTileColor = immutableTileColor;
        if(this.tileTextFieldState != TileTextFieldState.SETTING_MUTABLE_VALUE) {
            setBackground(this.immutableTileColor);
        }
    }
    
    /**
     * Set the mutable tile color
     * @param mutableTileColor Color object
     */
    public void setMutableTileColor(Color mutableTileColor) {
        this.mutableTileColor = mutableTileColor;
        if(this.tileTextFieldState == TileTextFieldState.SETTING_MUTABLE_VALUE) {
            setBackground(mutableTileColor);
        }
    }
    
    /**
     * Set tile state
     * @param tileTextFieldState 
     */
    public void setTileTextFieldState(TileTextFieldState tileTextFieldState) {
        this.tileTextFieldState = tileTextFieldState;
        setBackground(tileTextFieldState != 
                TileTextFieldState.SETTING_MUTABLE_VALUE ? this.immutableTileColor : this.mutableTileColor);
    }
    
    /**
     * Set tile value
     * @param value 
     */
    public void setText(int value) {
        setText(value == 0 ? "" : Integer.toString(value));
    }
}
