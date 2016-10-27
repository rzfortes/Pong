package Pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private static final int DIAMETER = 30;
    // the initial position of the ball
    int x = 50;
    int y = 100;
    // the variables below gives us the speed and direction
    int xa = 1;
    int ya = 1;
    private Game game;
    
    // variables for the scores of the players
    int player1 = 0;
    int player2 = 0;
	
    public Ball(Game game) {
        this.game = game;
    }
    
    // moves the ball
    void move() {
        
        boolean changeDirection = true;
        
        // right
        if(x + xa < 0) {
            xa = game.speed;
        }
        // left
        if(x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        }
        // if ni-lapas sa boundary ng upper racquet/player2, game over, player1 gets the point
        if(y + ya < 0) {
            player1++;
            game.gameOver();
        }
        // if ni-lapas sa boundary ng player1/lower racquet, game over, player2 gets the point
        if(y + ya > game.getHeight() - DIAMETER) {
            player2++;
            game.gameOver();
        }
        /* if nag-collide ang ball ang player1 racquet, direction is up
            player1 score incremented, speed ng racquet incremented also
        
            likewise for player2 (collision2), direction is down naman
        */
        if(collision()) {
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed = game.speed + 1;
            player1++;
        } else if(collision2()) {
            ya = game.speed;
            x = game.racquet2.getTopX() + DIAMETER;
            game.speed = game.speed + 1;
            player2++;
        } else {
            
            changeDirection = false;
        }
        
        // naay bug pa
        if(player1 >= 3||player2 >= 3){
            game.gameOver();
        }
        // sound effect for the collision of ball and racquet
        if(changeDirection) {
            Sound.BALL.play();
        }
        
        x = x + xa;
        y = y + ya;
    
    }
    
    // checks if nag-collide ang ball and racquet
    public boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
    
    public boolean collision2() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    // paint ball
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
