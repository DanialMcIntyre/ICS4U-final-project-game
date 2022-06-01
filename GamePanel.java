import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    Main main = new Main();

    final int framerate = 100;
    Timer timer = new Timer(1000 / framerate, this);

    private BufferedImage kartImg;
 
    Kart kart;

    CollidableRectangleObstacle ro1 = new CollidableRectangleObstacle(200, 500, 1500, 100, Color.BLACK, true);

    UncollidableRectangleObstacle uro1 = new UncollidableRectangleObstacle(1000, 250, 200, 600, Color.DARK_GRAY, true);

    CircleObstacle co1 = new CircleObstacle(100, 200, 50, 100, Color.BLUE, true);
   
    public GamePanel() {
 
        //Getting images
        try {
 
            kartImg = ImageIO.read(getClass().getResourceAsStream("images/misc/kart.png"));
 
            kart = new Kart(100, 100, 0, 0, 0, kartImg);
 
        } catch (IOException e) {
 
            e.printStackTrace();    
 
        }
 
    }
 
    //Draw stuff of screen
    public void paint(Graphics g) {
 
        //Clears screen
        super.paint(g);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1920, 1080);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Speed: " + String.valueOf((kart.getAcceleration() * kart.getAccTime()) / kart.getTractionLevel()), 500, 500);

        uro1.draw(g);
        ro1.draw(g);
        co1.draw(g);

        kart.draw(g);

        timer.start();
 
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {
 
        ro1.collision(kart);
        uro1.collision(kart);

        kart.updateKart();

        //Repaints screen
        repaint();
 
    }
 
}
