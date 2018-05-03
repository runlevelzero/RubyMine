/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

import java.awt.Image;
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
    public int BOARDX;
    public int BOARDY;
    private boolean clicked;
    private boolean flagged;
    private int scaleFactor;
    ImageIcon[] scaledImages;
    public static boolean[][] boardPos;
    
    public Square(int _x, int _y, int xMax, int yMax) {
        super();
        scaledImages     = new ImageIcon[14];
        numBomb          = 0;
        clicked          = false;
        BOARDX           = _x;
        BOARDY           = _y;
        boardPos         = new boolean[yMax][xMax];
        boardPos[_y][_x] = true;
        
        
    }

    public int getNumBomb() {
        return numBomb;
    }
    
    public boolean isFlagged() {
        return flagged;
    }
    
    public void checkIfIsCorrectFlag(boolean correct) {
        setIcon((this.flagged) ? scaledImages[12] : scaledImages[13]);
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
        setIcon((this.flagged) ? scaledImages[11] : scaledImages[10]);
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
            for(int a = BOARDY - 1; a < BOARDY + 2; a++) {
                for(int b = BOARDX - 1; b < BOARDX + 2; b++) {
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
            case 0: setIcon(scaledImages[0]);
                    break;
            case 1: setIcon(scaledImages[1]);
                    break;
            case 2: setIcon(scaledImages[2]);
                    break;
            case 3: setIcon(scaledImages[3]);
                    break;
            case 4: setIcon(scaledImages[4]);
                    break;
            case 5: setIcon(scaledImages[5]);
                    break;
            case 6: setIcon(scaledImages[6]);
                    break;
            case 7: setIcon(scaledImages[7]);
                    break;
            case 8: setIcon(scaledImages[8]);
                    break;
            case 9: setIcon(scaledImages[9]);
                    break;
            default: setIcon(scaledImages[0]);
                     break;
        }
        
    }
    public void setXY( int x, int y) {
        BOARDX = x;
        BOARDY = y;
    }
    public boolean[][] getXY() {
        return boardPos;
    }
    
    public void createScale(int scale) {
            scaledImages[0]  = shrinkToFit(new ImageIcon("0-32.png", "La Bomba"), scale);
            scaledImages[1]  = shrinkToFit(new ImageIcon("1-32.png", "La Bomba"), scale);
            scaledImages[2]  = shrinkToFit(new ImageIcon("2-32.png", "La Bomba"), scale);
            scaledImages[3]  = shrinkToFit(new ImageIcon("3-32.png", "La Bomba"), scale);
            scaledImages[4]  = shrinkToFit(new ImageIcon("4-32.png", "La Bomba"), scale);
            scaledImages[5]  = shrinkToFit(new ImageIcon("5-32.png", "La Bomba"), scale);
            scaledImages[6]  = shrinkToFit(new ImageIcon("6-32.png", "La Bomba"), scale);
            scaledImages[7]  = shrinkToFit(new ImageIcon("7-32.png", "La Bomba"), scale);
            scaledImages[8]  = shrinkToFit(new ImageIcon("8-32.png", "La Bomba"), scale);
            scaledImages[9]  = shrinkToFit(new ImageIcon("Bomb-32.png", "La Bomba"), scale);
            scaledImages[10] = shrinkToFit(new ImageIcon("Closed-32.png", "La Bomba"), scale);
            scaledImages[11] = shrinkToFit(new ImageIcon("Flag-32.png", "La Bomba"), scale);
            scaledImages[12] = shrinkToFit(new ImageIcon("CorrectFlag.png", "La Bomba"), scale);
            scaledImages[13] = shrinkToFit(new ImageIcon("IncorrectFlag.png", "La Bomba"), scale);
            setIcon(scaledImages[10]);
            
    }

    private ImageIcon shrinkToFit(ImageIcon image, int scale) {
        Image _image  = image.getImage();
        Image _imageP = _image.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
        return new ImageIcon(_imageP);
    }
    
}
