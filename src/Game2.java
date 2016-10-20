package minitennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

//@SupressWarning("serial");
public class Game2 extends JPanel {
    
    @Override
    // paint is called by the awt engine
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        // x and y axis && height and width of pixels
        // fill == painted, draw is draw
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);
        
        // other way of painting
        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
    }
}
