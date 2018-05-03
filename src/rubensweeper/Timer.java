/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubensweeper;

import javax.swing.JMenu;

/**
 *
 * @author ruben
 */
public class Timer extends JMenu implements Runnable{
    private Thread t;
    private String tName;
    private boolean iShouldKeepOnGoing = true;
    int time = 0;
    
    @Override
    public void run() {
        //System.out.println("running");
        try{
             if(iShouldKeepOnGoing) {
                //System.out.println("ran.");
                setEnabled(true);
                setText("Time: " + getTimeInThreeDigits());
                setEnabled(false);
                time++;
                Thread.sleep(1000);
                run();
             }
        } catch(InterruptedException e ) {
            System.out.println("Whoops! BUG SPLAT");
        }
    }
    
    public Timer() {
        super();
        setText("Timer: 000");
        tName = "timer_son";
    }
    

    private String getTimeInThreeDigits() {
        String ret = "";
        if (time >= 999) return "999";
        if (time < 100) ret += "0";
        if(time < 10) ret += "0";
        ret += Integer.toString(time);
        
        return ret;
        
    }
    
    public void stopTheClock() {
        iShouldKeepOnGoing = false;
    }
    
    public void start() {
        if(t == null) {
            setText("test");
            t = new Thread(this, tName);
            t.start();
        }
    }
    
}
