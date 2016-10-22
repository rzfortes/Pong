package minitennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    // the variables below gives us the speed and direction
    int xa = 1;
    int ya = 1;
    private Game game;
	
    public Ball(Game game) {
        this.game = game;
    }
    
    // moves the ball
    void move() {
        
        boolean changeDirection = true;
        
        if(x + xa < 0) {
        xa = game.speed;
        }
        if(x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        }
        if(y + ya < 0) {
            ya = game.speed;
        }
        if(y + ya > game.getHeight() - DIAMETER) {
            game.gameOver();
        }
        if(collision()) {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        } else {
            changeDirection = false;
        }
        
        if(changeDirection) {
            Sound.BALL.play();
        }
        x = x + xa;
        y = y + ya;
    
    }
    
    public boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    // receives the graphics2D, and paints
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
