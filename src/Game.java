/*
* MP4 Pong, from www.edu4java.com
* 10/21/2016
*/

package minitennis;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	
	// refers to the object made with "new"
		Ball ball = new Ball(this);
		Racquet racquet = new Racquet(this);
		
		public Game() {
			addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					racquet.keyReleased(e);
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					racquet.keyPressed(e);
				}
			});
		}
		
		private void move() {
			ball.move();
			racquet.move();
		}
	    
		@Override
	    public void paint(Graphics g) {
	        super.paint(g); // clears the screen
	        Graphics2D g2d = (Graphics2D) g;
	        // makes the borders of the figures smooth
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        ball.paint(g2d);
	        racquet.paint(g2d);
	        
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
	            game.move(); // updates the position of the ball
	            game.repaint(); // renders
	            Thread.sleep(10);
	        }
	    }
}
