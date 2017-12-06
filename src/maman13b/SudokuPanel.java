/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maman13b;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author elira
 */
public class SudokuPanel extends JPanel implements ActionListener {
    private final Color EVEN_BLOCK_COLOR = Color.WHITE;
    private final Color ODD_BLOCK_COLOR = Color.GRAY;
    private final String SET_BUTTON_NAME = "Set";
    private final String CLEAR_BUTTON_NAME = "Clear";
    private final int NUMBER_OF_ROWS = 9;
    private final int NUMBER_OF_COLUMNS = 9;
    private final ArrayList<TileTextField> tiles;
    private final TilesActionListener tilesListener;
    
    private JButton setButton;
    private JButton clearButton;
    
    /**
     * Empty constructor
     */
    public SudokuPanel() {
        tiles = new ArrayList<>();
        tilesListener = new TilesActionListener();
        createSudokuWindow();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e == null || !(e.getSource() instanceof JButton)) return;
        
        JButton button = (JButton) e.getSource();
        if(button.getText().equals(SET_BUTTON_NAME)) { // Set button clicked
            setButtonClicked();
        }
        else { // Clear button clicked
            clearButtonClicked();
        }
    }
    
    private void setButtonClicked() {
        for(TileTextField tile : this.tiles) {
            if(tile.isFilled()) {
                tile.lockTile(); // Set immutable tiles
            }
        }
        
        setButton.setEnabled(false);
    }
    
    private void clearButtonClicked() {
        for(TileTextField tile : this.tiles) {
            tile.clearTile();
        }
        setButton.setEnabled(true);
    }
    
    private void createSudokuWindow() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(createGridPanel());
        add(createFormButtons());
    }
    
    private JPanel createGridPanel() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
        createTiles(gridPanel);
        
        return gridPanel;
    }
    
    private void createTiles(JPanel panel) {
        for(int i = 0; i < NUMBER_OF_ROWS; i++) {
            for(int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                TileTextField tile = new TileTextField(i, j, this.tilesListener);
                setTileColor(tile, i, j);
                this.tiles.add(tile);
                this.tilesListener.addTile(tile);
                panel.add(tile);
            }
        }
    }
    
    private void setTileColor(TileTextField tile, int row, int column) {    
        // Set background according to blocks
        if(row >= 0 && row <= 2) {
            if(column >= 3 && column <= 5) {
                tile.setBackground(EVEN_BLOCK_COLOR);
            }
            else {
                tile.setBackground(ODD_BLOCK_COLOR);
            }
        }
        else if(row >= 3 && row <= 5) {
            if(column >= 3 && column <= 5) {
                tile.setBackground(ODD_BLOCK_COLOR);
            }
            else {
                tile.setBackground(EVEN_BLOCK_COLOR);
            }
        }
        else {
            if(column >= 3 && column <= 5) {
                tile.setBackground(EVEN_BLOCK_COLOR);
            }
            else {
                tile.setBackground(ODD_BLOCK_COLOR);
            }
        }
    }
    
    private JPanel createFormButtons() {
        this.setButton = new JButton(SET_BUTTON_NAME);
        this.clearButton = new JButton(CLEAR_BUTTON_NAME);
        
        // Add events
        this.setButton.addActionListener(this);
        this.clearButton.addActionListener(this);
        
        // Create panel
        JPanel panel = new JPanel();
        panel.add(this.setButton);
        panel.add(this.clearButton);
        
        return panel;
    }
}
