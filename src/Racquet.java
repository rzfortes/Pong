package Pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
    private int Y; // for the position of the racquet along y axis
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;

    // position of the racquet along x axis
    int x = 400 / 2;
    int xa = 0;
    private Game game;

    public Racquet(Game game, int Y) {
        this.game = game;
        this.Y = Y;
    }
    
    public void setY(int Y) {
        this.Y = Y;
    }

    public void move() {
        if((x + xa > 0) && (x + xa < game.getWidth() - WIDTH)) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    
    public int getTopY() {
        return Y - HEIGHT;
    }
    
    public int getTopX() {
        return x - HEIGHT;
    }

}
