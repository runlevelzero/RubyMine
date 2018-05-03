/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;

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
    Smiley face;
    Timer time;
    JMenu sre;
    int score;
    Boolean isFirstClick;
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
        face           = null;
        isFirstClick   = true;
        score          = 0;
        sml            = // <editor-fold defaultstate="collapsed" desc="Mouse Listener for the Squares"> 
            new MouseListener() {
                    
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mouseEventPerformed(e);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        face.setIcon(new ImageIcon("clicked.png", "¯\\_(ツ)_/¯"));
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                        face.setIcon(new ImageIcon("start.png", "¯\\_(ツ)_/¯"));
                        
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
        //printCoordinates();
    }

    private void generateBombs() {
        System.out.println(totalNumBombs);
        while(totalNumBombs > 0 ){
            
            for(int y = 0; y < grid.length; y++) {
                
                    for(int x = 0; x < grid[y].length; x++) {
                        
                        if(totalNumBombs > 0){
                            
                            if((int)(Math.random() * 11) == 10) {
                                //System.out.println("ran.");
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
                    //System.out.print("[ " + x + " , " + y + " ] : ");
                    grid[y][x] = new Square(x,y, getHorizLength(), getVertLength());
                    //System.out.print("< " + grid[y][x].BOARDX + " , " + grid[y][x].BOARDY + " >\t");

            }
            //System.out.println();
        }

    }
    
    private void mouseEventPerformed(MouseEvent e) {
        if(isFirstClick) {
            time.start();
            isFirstClick = false;
        }
        Square sq = (Square) e.getSource();
        //System.out.println("< " + sq.BOARDX + " , " + sq.BOARDY + " >");
        int button = e.getButton();
        //System.out.println(button);
        switch(button) {
            case 1:
                if(!sq.isFlagged() && isStillGood())sq.setClicked(true);
                if(isStillGood() && sq.getNumBomb() == 9 && sq.isClicked()) {
                    loseCycle();
                    score -= 99999999;
                    updateScore();
                }
                else if(isStillGood() && sq.getNumBomb() == 0 && sq.isClicked()) {
                    /*bse.setStartingSpots(sq.y, sq.x);
                    bse.print();
                    bse.findAllBlanks();*/
                    //sq.openBlankSpace(grid);
                    openAllBlanksAround(sq.BOARDY,sq.BOARDX, true);
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
            flagCheck();
        }
        
        
    }
    
    private void unFlagSequence(Square sq) {
        sq.setFlagged(false);
        sq.setIcon(new ImageIcon("Closed-32.png", "La Bomba"));
        flagsRemaining++;
    }
    
    private void revealAllBombs() {
        //System.out.println("Ran.");
        time.stopTheClock();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                Square s = grid[i][j];
                if(s.isFlagged() && s.getNumBomb() != 9) s.checkIfIsCorrectFlag(false);
                else if(s.isFlagged() && s.getNumBomb() == 9 )s.checkIfIsCorrectFlag(true);
                else if(s.getNumBomb() == 9) s.setClicked(true);
            }
        }
    }
    
    private void winCycle() {
        revealAllBombs();
        face.setIcon(new ImageIcon("Win.png", "¯\\_(ツ)_/¯"));
        stillGood = false;
    }
    
    private void loseCycle() {
        revealAllBombs();
        face.setIcon(new ImageIcon("Lose.png", "¯\\_(ツ)_/¯"));
        stillGood = false;
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
            //System.out.println(x + ": ");
            for(Square j: i) {
                //System.out.println("\t" + y);
                numGrid[x][y] = j.getNumBomb();
                y++;
            }
            x++;
            y = 0;
        }
        /*for(int[] i : numGrid) {
            for(int j: i) {
                System.out.print( j + " ");
            }
            System.out.println();
        }*/
        
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

    private void openAllBlanksAround(int y, int x, boolean first) {
        //System.out.println("( " + x + " , " + y + " )");
        if(y < grid.length && y >= 0 && x < grid[y].length && x >= 0) {
            if(!grid[y][x].isClicked() || first) {
                if(numGrid[y][x] != 0) {
                    grid[y][x].setClicked(true);
                    score += 10;
                    updateScore();
                    
                }
                else if(numGrid[y][x] == 0){
                    grid[y][x].setClicked(true);
                    openAllBlanksAround(y - 1, x, false);
                    openAllBlanksAround(y + 1, x, false);
                    openAllBlanksAround(y, x - 1, false);
                    openAllBlanksAround(y, x + 1, false);
                }
            }
        }
    }

    public void printCoordinates() {
        System.out.println("--");
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                Square j = grid[x][y];
                System.out.print("[ " + y + " , " + x + " ] : ");
                System.out.print("< " + grid[x][y].BOARDX + " , " + grid[x][y].BOARDY + " >\t");
            }
            System.out.println();
        }
    }

    

    void setSmiley(JLabel titleSlot) {
        face = (Smiley)titleSlot;
    }

    private void flagCheck() {
        int countBombs = 0;
        int correctFlags = 0;
        for(int a = 0; a < grid.length; a++) {
            for(int b = 0; b < grid[0].length; b++) {
                if(grid[a][b].getNumBomb() == 9){
                    countBombs++;
                    
                    if(grid[a][b].isFlagged()) {
                        correctFlags++;
                    }
                }
            }
        }
        if(countBombs == correctFlags) {
            winCycle();
        }
    }

    void grabTheTimer(Timer timer1) {
        time = timer1;
    }

    void grabTheScore(JMenu score) {
        sre = score;
    }

    private void updateScore() {
        sre.setText("Score: " + getScoreInThreePlusDigits());
    }
    private String getScoreInThreePlusDigits() {
        String ret = "";
        if (score >= 999 || score < 0) return "" + score;
        if (score < 100) ret += "0";
        if(score < 10) ret += "0";
        ret += Integer.toString(score);
        
        return ret;
        
    }
    public void setScale(int scale) {
        for (Square[] i : grid) {
            for (Square j : i) {
                j.createScale(scale);
            }
        }
    }

    
    
}
