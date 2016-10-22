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
    
    // movement of the ball
    void move() {
        // if the direction of the ball changes, variable will be true
	// this will be used in a condition where if the direction of the ball still changes, play the sound provided
        boolean changeDirection = true;
        
        if(x + xa < 0) {
        xa = 1;
        }
        if(x + xa > game.getWidth() - DIAMETER) {
            xa = -1;
        }
        if(y + ya < 0) {
            ya = 1;
        }
	// nilapas na ang ball, game over
        if(y + ya > game.getHeight() - DIAMETER) {
            game.gameOver();
        }
	// 
        if(collision()) {
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
        } else {
            changeDirection = false;
        }
        // condition where if the direction of the ball changes, play the sound provided
        if(changeDirection) {
            Sound.BALL.play();
        }
        x = x + xa;
        y = y + ya;
    
    }
    
    public boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    // paints the ball
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
