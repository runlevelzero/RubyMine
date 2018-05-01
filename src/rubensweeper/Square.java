/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Data Class will change the Icon Instance Variable based on numbers
 * 0 - Blank
 * 1 - Blue
 * 2 - green
 * 3 - purple
 * 5 - Dark Red
 * 6 - Teal
 * 7 - Black
 * 8 - Grey
 * 9 - Snek
 * Right Click - Flag on Button
 * @author ruiz_854748
 */
public class Square extends JLabel{
    
    /**
     * numBomb - the number of bombs around it
     *           if it says anything from 1-8 there are bombs around it
     *           if it says 0 there are no bombs around it
     *           if it says 9 it itself is a bomb
     */
    private int numBomb;
    public static int x;
    public static int y;
    private boolean clicked;
    private boolean flagged;
    
    public Square(int _x, int _y) {
        super();
        numBomb = 0;
        clicked = false;
        y = _y;
        x = _x;
        
    }

    public int getNumBomb() {
        return numBomb;
    }
    
    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
        setIcon((this.flagged) ? new ImageIcon("Flag-32.png", "La Bomba") : new ImageIcon("Closed-32.png", "La Bomba"));
    }
    
    public void findNumBomb(Square[][] grid, int y, int x) {
        int totalNumBombsAround = 0;
        if(numBomb == 9) return;
        else{
            for(int a = y - 1; a < y + 2; a++) {
                for(int b = x - 1; b < x + 2; b++) {
                    if(a >= 0 && a < grid.length && b >= 0 && b < grid.length ) {
                        if(grid[a][b].getNumBomb() == 9) totalNumBombsAround++;
                    }
                }
            }
        }
        setNumBomb(totalNumBombsAround);
    }
    public void openBlankSpace(Square[][] grid) {
        setClicked(true);
        int totalNumBombsAround = 0;
        if(numBomb == 9) return;
        else{
            for(int a = y - 1; a < y + 2; a++) {
                for(int b = x - 1; b < x + 2; b++) {
                    if(a >= 0 && a < grid.length && b >= 0 && b < grid.length ) {
                        if(grid[a][b].getNumBomb() == 0 && !grid[a][b].isClicked()) {
                            
                            grid[a][b].openBlankSpace(grid);
                        }
                        else if(grid[a][b].getNumBomb() > 9 && !grid[a][b].isClicked()) {
                            grid[a][b].setClicked(true);
                        }
                    }
                }
            }
        }
        
        //setNumBomb(totalNumBombsAround);
    }
    public void setNumBomb(int numBomb) {
        this.numBomb = numBomb;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
        switch(numBomb) {
            case 0: setIcon(new ImageIcon("0-32.png", "La Bomba"));
                    break;
            case 1: setIcon(new ImageIcon("1-32.png", "La Bomba"));
                    break;
            case 2: setIcon(new ImageIcon("2-32.png", "La Bomba"));
                    break;
            case 3: setIcon(new ImageIcon("3-32.png", "La Bomba"));
                    break;
            case 4: setIcon(new ImageIcon("4-32.png", "La Bomba"));
                    break;
            case 5: setIcon(new ImageIcon("5-32.png", "La Bomba"));
                    break;
            case 6: setIcon(new ImageIcon("6-32.png", "La Bomba"));
                    break;
            case 7: setIcon(new ImageIcon("7-32.png", "La Bomba"));
                    break;
            case 8: setIcon(new ImageIcon("8-32.png", "La Bomba"));
                    break;
            case 9: setIcon(new ImageIcon("Bomb-32.png", "La Bomba"));
                    break;
            default: setIcon(new ImageIcon("0-32.png", "La Bomba"));
                     break;
        }
        
    }
    
}
