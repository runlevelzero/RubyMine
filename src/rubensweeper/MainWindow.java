
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rubensweeper;

// <editor-fold defaultstate="collapsed" desc="Import Block"> 
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
// </editor-fold>


/**
 *
 * @author ruiz_854748
 */
public class MainWindow extends javax.swing.JFrame {

    Grid grid;
    int scale;
    boolean firstClick;
    MouseListener ml     = // <editor-fold defaultstate="collapsed" desc="Mouse Listener for the MenuButton"> 
            new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        gameWindow.removeAll();
                        startGame();
                        gameWindow.updateUI();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        titleSlot.setIcon(new ImageIcon("clicky.png", "¯\\_(ツ)_/¯"));
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        titleSlot.setIcon(new ImageIcon("start.png", "¯\\_(ツ)_/¯"));
                        //startGame();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }
                };// </editor-fold>
    MouseListener winml  = // <editor-fold defaultstate="collapsed" desc="Mouse Listener for the JPanel"> 
            new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        titleSlot.setIcon(new ImageIcon("clicky.png", "¯\\_(ツ)_/¯"));
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        titleSlot.setIcon(new ImageIcon("start.png", "¯\\_(ツ)_/¯"));
                        //startGame();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }
                }; // </editor-fold>
    MouseListener gridml = // <editor-fold defaultstate="collapsed" desc="Mouse Listener for the grid to start the timer"> 
            new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        if(firstClick) {
                            timer1.start();
                            firstClick = false;
                        }
                        if(!grid.isStillGood()) {
                            timer1.stopTheClock();
                        }
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
                }; // </editor-fold>
    

    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        
        
        initComponents();
        startGame();
        firstClick = true;
        this.setIconImage(new ImageIcon("Flag-32.png").getImage());
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        diffButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        titleSlot = new Smiley();
        gameWindow = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        easyRadio = new javax.swing.JRadioButtonMenuItem();
        mediumRadio = new javax.swing.JRadioButtonMenuItem();
        hardRadio = new javax.swing.JRadioButtonMenuItem();
        titleTextSlot = new javax.swing.JMenu();
        timer1 = new rubensweeper.Timer();
        score = new javax.swing.JMenu();

        jLabel1.setText("Choose Your Difficulty");

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        jLabel4.setText("X (Minimum 6)");

        jLabel5.setText("Y (Minimum 6)");

        jButton1.setText("OK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RubyMine Minesweeper Application");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        titleSlot.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        titleSlot.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(titleSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleSlot, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        gameWindow.setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout gameWindowLayout = new javax.swing.GroupLayout(gameWindow);
        gameWindow.setLayout(gameWindowLayout);
        gameWindowLayout.setHorizontalGroup(
            gameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        gameWindowLayout.setVerticalGroup(
            gameWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jMenu1.add(newGame);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Game Options");

        jMenu3.setText("Game Difficulty");

        diffButtonGroup.add(easyRadio);
        easyRadio.setSelected(true);
        easyRadio.setText("Easy (9x9)");
        jMenu3.add(easyRadio);

        diffButtonGroup.add(mediumRadio);
        mediumRadio.setText("Medium (18x18)");
        jMenu3.add(mediumRadio);

        diffButtonGroup.add(hardRadio);
        hardRadio.setText("Hard (75x128)");
        jMenu3.add(hardRadio);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        titleTextSlot.setText("                                                 ");
        titleTextSlot.setEnabled(false);
        jMenuBar1.add(titleTextSlot);

        timer1.setText("Timer: 000");
        timer1.setEnabled(false);
        jMenuBar1.add(timer1);

        score.setText("Score: 0");
        score.setEnabled(false);
        jMenuBar1.add(score);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gameWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(gameWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
        gameWindow.removeAll();
        startGame();
        gameWindow.updateUI();
    }//GEN-LAST:event_newGameActionPerformed
    // </editor-fold>
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            //    System.out.println(info.getName());
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                
            //}
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Variable Declarations"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup diffButtonGroup;
    private javax.swing.JRadioButtonMenuItem easyRadio;
    private javax.swing.JPanel gameWindow;
    private javax.swing.JRadioButtonMenuItem hardRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButtonMenuItem mediumRadio;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JMenu score;
    private rubensweeper.Timer timer1;
    private javax.swing.JLabel titleSlot;
    private javax.swing.JMenu titleTextSlot;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    
    private void initializeGrid() {
        
        gameWindow.setLayout(new GridBagLayout());
        for(int y = 0; y < grid.getVertLength(); y++){
            for(int x = 0; x < grid.getHorizLength(); x++) {
                GridBagConstraints c = new GridBagConstraints();
                
                c.gridx = x;
                c.gridy = y;
                c.weightx = 0;
                c.weighty = 0;
                
                Square sq = grid.getSquareAt(x, y);
                sq.setXY(x, y);
                gameWindow.add(sq, c);
                
                
                
                // This is where the mouse listener gets tied to a universal onClick Method to handle square selection
                sq.addMouseListener(grid.getDefaultSML());
            }
        }
    }

    private void startGame() {
        if(easyRadio.isSelected()) {
            grid = new Grid(9, 9);
            scale = 32;
        }
        else if (mediumRadio.isSelected())  {
            setPreferredSize(new Dimension(480,720));
            pack();
            setVisible(true);
            grid = new Grid(18, 18);
            scale = 24;
            
        }
        else if (hardRadio.isSelected()) {
            setPreferredSize(new Dimension(1600,900));
            pack();
            setVisible(true);
            
            grid = new Grid(75,128);
            scale = 8;
            
        }

        grid.startGame();
        grid.setScale(scale);
        titleSlot.addMouseListener(ml);
        grid.setSmiley(titleSlot);
        grid.grabTheTimer(timer1);
        grid.grabTheScore(score);
        gameWindow.addMouseListener(winml);
        initializeGrid();
        //grid.printCoordinates();
        grid.print();
        
    }
    
}
    
    
    
    

