/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author ruiz_854748
 */
public class Grid {

    Square[][] grid;
    int[][] numGrid;
    boolean stillGood;
    int totalNumBombs;
    int flagsRemaining;
    
    MouseListener sml;
    BlankSpaceExpanderTraverser bse;
    
    public Grid(int xSize, int ySize) {
        // <editor-fold defaultstate="collapsed" desc="Constructor for the Grid"> 
        grid           = new Square[xSize][ySize];
        numGrid        = new int[xSize][ySize];
        stillGood      = true;
        totalNumBombs  = (int)((xSize * ySize) / 5);
        flagsRemaining = totalNumBombs;
        bse            = BlankSpaceExpanderTraverser.getInstance();
        sml            = // <editor-fold defaultstate="collapsed" desc="Mouse Listener for the Squares"> 
            new MouseListener() {
                    
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mouseEventPerformed(e);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                        
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }

                    
                };//</editor-fold>

       // </editor-fold> 
    }
    
    public void startGame() {
        createGrid();
        bse.setGrid(grid);
        generateBombs();
        generateNumbers();
        populateNumArr();
    }

    private void generateBombs() {
        while(totalNumBombs > 0 ){
            
            for(int y = 0; y < grid.length; y++) {
                
                    for(int x = 0; x < grid[y].length; x++) {
                        
                        if(totalNumBombs > 0){
                            
                            if((int)(Math.random() * 11) == 10) {
                                System.out.println("ran.");
                                grid[y][x].setNumBomb(9);
                                totalNumBombs--;
                                
                            }
                            
                        }
                    }
            }
        }
    }
    
    private void generateNumbers() {
        
        for(int y = 0; y < grid.length; y++) {
                for(int x = 0; x < grid[y].length; x++) {
                        grid[y][x].findNumBomb(grid,y,x);
                }
        }
        
        
    }
    
    private void createGrid() {
        
        for(int y = 0; y < grid.length; y++) {
                for(int x = 0; x < grid[y].length; x++) {
                        grid[y][x] = new Square(x,y);
                }
        }
        
        
    }
    
    private void mouseEventPerformed(MouseEvent e) {
        Square sq = (Square) e.getSource();
        int button = e.getButton();
        //System.out.println(button);
        switch(button) {
            case 1:
                if(!sq.isFlagged() && isStillGood())sq.setClicked(true);
                if(isStillGood() && sq.getNumBomb() == 9 && sq.isClicked()) loseCycle();
                else if(isStillGood() && sq.getNumBomb() == 0 && sq.isClicked()) {
                    /*bse.setStartingSpots(sq.y, sq.x);
                    bse.print();
                    bse.findAllBlanks();*/
                    //sq.openBlankSpace(grid);
                    openAllBlanksAround(sq.y,sq.x);
                }
                break;
            case 3:
                if(!sq.isFlagged() && isStillGood()) {
                    flagSequence(sq);
                }
                else if(isStillGood()){
                    unFlagSequence(sq);
                }
                
        }
    }
    
    private void flagSequence(Square sq) {
        if(flagsRemaining > 0) {
            sq.setFlagged(true);
            flagsRemaining--;
        }
        
        
    }
    
    private void unFlagSequence(Square sq) {
        sq.setFlagged(false);
        sq.setIcon(new ImageIcon("Closed-32.png", "La Bomba"));
        flagsRemaining++;
    }
    
    private void revealAllBombs() {
        //System.out.println("Ran.");
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                Square s = grid[i][j];
                if(s.isFlagged() && s.getNumBomb() != 9) s.setIcon(new ImageIcon("IncorrectFlag.png", "¯\\_(ツ)_/¯"));
                else if(s.isFlagged() && s.getNumBomb() == 9 )s.setIcon(new ImageIcon("Flag-32.png", "La Bomba"));
                else if(s.getNumBomb() == 9) s.setClicked(true);
            }
        }
    }
    
    private void loseCycle() {
        revealAllBombs();
    }
    
    public boolean isStillGood() {
        return stillGood;
    }
    
    public Square[][] getGrid() {
        return grid;
    }
    
    public Square getSquareAt(int x, int y) {
        return grid[y][x];
    }
    
    public MouseListener getDefaultSML() {
        return sml;
    }
    
    public int getHorizLength() {
        return grid[0].length;
    }
    
    public int getVertLength() {
        return grid.length;
    }
    
    @Override
    public String toString() {
        
        String ret = "";
        for(Square[] i : grid) {
            for(Square j: i) {
                ret += j.getNumBomb() + " ";
            }
            ret += "\n";
        }
        return ret;
        
    }
    
    public void print() {
        
        for(Square[] i : grid) {
            for(Square j: i) {
                System.out.print( j.getNumBomb() + " ");
            }
            System.out.println();
        }
        System.out.println(grid.length);
        
    }
    
    public void populateNumArr() {
        
        int x = 0;
        int y = 0;
        for(Square[] i : grid) {
            System.out.println(x + ": ");
            for(Square j: i) {
                System.out.println("\t" + y);
                numGrid[x][y] = j.getNumBomb();
                y++;
            }
            x++;
            y = 0;
        }
        for(int[] i : numGrid) {
            for(int j: i) {
                System.out.print( j + " ");
            }
            System.out.println();
        }
        
    }

    private void checkIfAllAreZeros() {
        boolean allAreZeros = true;
        for(Square[] i : grid) {
            for(Square j : i) {
                if(j.getNumBomb() != 0) {
                    allAreZeros = false;
                    break;
                }
            }
        }
        if(allAreZeros) {
            totalNumBombs = flagsRemaining;
            generateBombs();
            generateNumbers();
        }
    }

    private void openAllBlanksAround(int y, int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
