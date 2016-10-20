/*
* MP4 Pong, from www.edu4java.com
* 10/21/2016
*/

package minitennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    int x = 0;
    int y = 0;
    // the variables below gives us the speed and direction
    int xa = 1;
    int ya = 1;
    
    private void moveBall() {
        
        if(x + xa < 0) {
            xa = 1;
        } 
        if(x + xa > getWidth() - 30) {
            xa = -1;
        }
        if(y + ya < 0) {
            ya = 1;
        }
        if(y + ya > getHeight() - 30) {
            ya = -1;
        }
        
        x = x + xa;
        y = y + ya;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); // clears the screen
        Graphics2D g2d = (Graphics2D) g;
        // makes the borders of the figures smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        // the window that will frame the panel object of minitennis
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true) {
            game.moveBall(); // updates the position of the ball
            game.repaint(); // renders
            Thread.sleep(10);
        }
    }
}
