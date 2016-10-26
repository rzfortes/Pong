/*
* MP4 Pong, from www.edu4java.com
* 10/21/2016
*/

package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
    
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    Racquet2 racquet2 = new Racquet2(this);
    
    int speed = 1;
    
    // also the winner part
    private int getScore() {
        if(ball.player1 > ball.player2) {
            return ball.player1;
        }
        return ball.player2;
    }

    public Game() {
        addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
                racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
                racquet2.keyPressed(e);
            }
        });
        // should not forget, dili mu-move ang racquet if wala ni
        setFocusable(true);
        Sound.BACK.loop();
    }
    
    // moves everything
    private void move() {
        ball.move();
        racquet.move();
        racquet2.move();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); // clears the screen
        Graphics2D g2d = (Graphics2D) g;
        // makes the borders of the figures smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        ball.paint(g2d);
        racquet.paint(g2d);
        racquet2.paint(g2d);
        
        // player 1 score and player 2 score, same font and color
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Verdana", Font.BOLD, 25));
        g2d.drawString(String.valueOf(ball.player2), 10, 30);
        g2d.drawString(String.valueOf(ball.player1), 10, 350);
        g2d.setFont(new Font("Verdana", Font.BOLD, 10));
        g2d.drawString("Player 1", 10, 320);
        g2d.drawString("Player 2", 10, 50);
    }
    
    public void gameOver() {
        // stop the sound effect of ball and racquet collision
        Sound.BACK.stop();
        // sound effect for game over, NOTE: should change
        Sound.GAMEOVER.play();
        // for displaying the which player won
        String player;
        if(ball.player1 == ball.player2) {
            player = "No one";
        } else if(ball.player1 > ball.player2){
            player = "Player 1";
        } else {
            player = "Player 2";
        }
        JOptionPane.showMessageDialog(this, player + " wins! \nScore is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        
        // restarting the game option, NOTE: NEED TO FIND OUT HOW TO DELETE OR RESET BC DUHA KA JFRAME NA
        int n = JOptionPane.showConfirmDialog(this, "Restart game?", "Game Over", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            try {
                RestartGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.exit(ABORT);
        }
    }
    
    // restart the game if yes, NOTE: SHOULD FIND OUT HOW TO DELETE THE FIRST JFRAME, OR RESET MAN LANG
    public void RestartGame() throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        game.setBackground(Color.LIGHT_GRAY);
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            game.move(); // updates the position of the ball
            game.repaint(); // renders
            Thread.sleep(10);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        // the window that will frame the panel object of minitennis
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        game.setBackground(Color.LIGHT_GRAY);
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            game.move(); // updates the position of the ball
            game.repaint(); // renders
            Thread.sleep(10);
        }
    }
}
