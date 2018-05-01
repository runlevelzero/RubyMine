/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

/**
 *
 * @author ruben
 */
public class BlankSpaceExpanderTraverser {
    
    Square[][] grid;
    int startingSpotY, startingSpotX;
    
    private BlankSpaceExpanderTraverser() {
    }
    
    public void setGrid(Square[][] g) {
        grid = g;
    }
    
    public void setStartingSpots(int y, int x) {
        startingSpotY = y;
        startingSpotX = x;
    }
    
    public void findAllBlanks() {
        System.out.println("Let's Find thos Blanks! ;D");
        int x = startingSpotX;
        int y = startingSpotY;
        System.out.println(Integer.toString(grid[startingSpotY][startingSpotX].getNumBomb()) + " : " + Boolean.toString(grid[startingSpotY][startingSpotX].getNumBomb() == 0) );
        //if(false){
        if(grid[startingSpotY][startingSpotX].getNumBomb() == 0) {
            while(y >= 0) {
                System.out.println("Goin' Up ^^ " + y );
                goLeft(x,y);
                goRight(x,y);
                y--;
            }
            x = startingSpotX;
            y = startingSpotY;
            while(y < grid.length) {
                System.out.println("Goin' Down vv " + y );
                goLeft(x,y);
                goRight(x,y);
                y++;
            }
        }
    }
    
    private void goLeft(int x, int y) {
        
        if(x < 0 ) return;
        else if(grid[y][x].getNumBomb() > 0 && grid[y][x].getNumBomb() != 9 && !grid[y][x].isFlagged()) {
            System.out.println("Gone Left from (" + x + ", " + y + ")");
            grid[y][x].setClicked(true);
            
        }
        else if(x == startingSpotX && y == startingSpotY) goLeft(x-1,y);
        else if (grid[y][x].getNumBomb() == 0) {
            grid[y][x].setClicked(true);
            System.out.println("Gone Left from (" + x + ", " + y + ")STOP");
            goLeft(x-1,y);
            
        }
        
    }
    
    private void goRight(int x, int y) {
        if(x >= grid[y].length) return;
        else if(x == startingSpotX && y == startingSpotY) goRight(x+1,y);
        else if (grid[y][x].getNumBomb() == 0) {
            grid[y][x].setClicked(true);
            System.out.println("Gone Right from (" + x + ", " + y + ")");
            goRight(x + 1,y);
        }
        else if(grid[y][x].getNumBomb() > 0 && grid[y][x].getNumBomb() != 9 && !grid[y][x].isFlagged()) {
            System.out.println("Gone Right from (" + x + ", " + y + ") STOP");
            grid[y][x].setClicked(true);
        }
        
        
    }
    public void print() {
        
        String ret = "";
        for(Square[] i : grid) {
            for(Square j: i) {
                System.out.print( j.getNumBomb() + " ");
            }
            System.out.println();
        }
        System.out.println(grid.length);
        
    }
    
    public static BlankSpaceExpanderTraverser getInstance() {
        return BlankSpaceExpanderTraverserHolder.INSTANCE;
    }
    
    private static class BlankSpaceExpanderTraverserHolder {

        private static final BlankSpaceExpanderTraverser INSTANCE = new BlankSpaceExpanderTraverser();
    }
}
