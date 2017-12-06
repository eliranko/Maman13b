package maman13b;

import javax.swing.JFrame;

public class Maman13b {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;
    
    public static void main(String[] args) {
        SudokuPanel panel = new SudokuPanel();
        JFrame frame = new JFrame("Maman 13b");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
}