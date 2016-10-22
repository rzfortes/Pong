package minitennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Game game;

    public Racquet(Game game) {
        this.game = game;
    }

    public void move() {
	// as long as x (value in the x-axis) + xa (speed and direction) is greater than 0, mu-move ang racquet padung sa value of x
	// likewise, as long as the sum of x and xa is within the range of somewhat "border" ng game
        if((x + xa > 0) && (x + xa < game.getWidth() - 60)) {
            x = x + xa;
        }
    }

    // paints the racquet
    public void paint(Graphics2D g) {
        g.fillRect(x, 330, 60, 10);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 1;
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    
    public int getTopY() {
        return Y;
    }

}
