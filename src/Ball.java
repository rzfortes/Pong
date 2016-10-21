package minitennis;

import java.awt.Graphics2D;

public class Ball {
	
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
		
		if(x + xa < 0) {
            xa = 1;
        } 
        // moves to the left
        if(x + xa > game.getWidth() - 30) {
            xa = -1;
        }
        if(y + ya < 0) {
            ya = 1;
        }
        if(y + ya > game.getHeight() - 30) {
            ya = -1;
        }
        
        x = x + xa;
        y = y + ya;
	}
	
	// receives the graphics2D, and paints
	public void paint(Graphics2D g){
		g.fillOval(x, y, 30, 30);
	}

}
