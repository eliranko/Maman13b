package maman13b;

import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class TileTextField extends JTextField {
    public static final String DEFAULT_TILE_VALUE = "";
    private int row;
    private int column;
    private boolean isLocked;
    
    /**
     * Empty constructor.
     * Default immutable color is gray
     * Default mutable color is white
     * Default state is SETTING_IMMUTABLE_VALUE
     */
    public TileTextField() {
        row = column = 0;
        this.isLocked = false;
        setHorizontalAlignment(CENTER);
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
     * @param row tile row
     * @param column tile column
     * @param listener Action listener object
     */
    public TileTextField(int row, int column, ActionListener listener) {
        this(listener);
        this.row = row;
        this.column = column;
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
    
    /**
     * Get indication if the tile is locked
     * @return true if locked, false otherwise
     */
    public boolean isLocked() {
        return isLocked;
    }
    
    /**
     * Get indication if the tile is filled with a value
     * @return true if filled, false otherwise
     */
    public boolean isFilled() {
        return !getText().isEmpty();
    }
    
    /**
     * Lock tile
     */
    public void lockTile() {
        this.isLocked = true;
        setEnabled(false);
    }
    
    /**
     * Unlock tile
     */
    public void unlockTile() {
        this.isLocked = false;
        setEnabled(true);
    }
    
    /**
     * Clear tile
     */
    public void clearTile() {
        unlockTile();
        setText(DEFAULT_TILE_VALUE);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof TileTextField)) return false;
        
        TileTextField tile = (TileTextField) obj;
        return getText().equals(tile.getText()) && this.row == tile.getRow() && 
                this.column == tile.getColumn();
    }
}
