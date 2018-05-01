/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

/**
 *
 * @author ruiz_854748
 */
public class ZeroExpanderTraverser {
    Square[][] grid;
    int startingSpotY, startingSpotX;
    public ZeroExpanderTraverser(Square[][] inGrid, int sY, int sX) {
        grid = inGrid;
        startingSpotY = sY;
        startingSpotX = sX;
        for(int y = 0; y < grid.length; y++) {
                for(int x = 0; x < grid[y].length; x++) {
                        grid[y][x].findNumBomb(grid,y,x);
                }
        }
    }
    
    public void findAllBlanks() {
        int x = startingSpotX;
        int y = startingSpotY;
        x = 0;
        y = 0;
        if(grid[startingSpotY][startingSpotX].getNumBomb() == 0) {
            while(y > 0) {
                //goLeft(x,y);
                goRight(x,y);
                y--;
            }
            x = startingSpotX;
            y = startingSpotY;
            while(y < grid.length) {
                //goLeft(x,y);
                goRight(x,y);
                y++;
            }
        }
    }
    private void goLeft(int x, int y) {
        if(x < 0 ) return;
        if(x == startingSpotX && y == startingSpotY) goLeft(x-1,y);
        else if(grid[y][x].getNumBomb() > 0 && grid[y][x].getNumBomb() != 9 && !grid[y][x].isFlagged()) {
            grid[y][x].setClicked(true);
        }
        else if (grid[y][x].getNumBomb() == 0) {
            grid[y][x].setClicked(true);
            goLeft(x-1,y);
        }
        
    }
    private void goRight(int x, int y) {
        //System.out.printf
        if(x > grid[y].length) return;
        if(x == startingSpotX && y == startingSpotY) goRight(x+1,y);
        else if(grid[y][x].getNumBomb() > 0 && grid[y][x].getNumBomb() != 9 && !grid[y][x].isFlagged()) {
            grid[y][x].setClicked(true);
        }
        else if (grid[y][x].getNumBomb() == 0) {
            grid[y][x].setClicked(true);
            goLeft(x + 1,y);
        }
        
    }
    
}
