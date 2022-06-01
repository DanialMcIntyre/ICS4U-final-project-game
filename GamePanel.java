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

    RectangleObstacle ro1 = new RectangleObstacle(500, 10, 500, 100, true);

    CircleObstacle co1 = new CircleObstacle(100, 200, 50, 100, true);
   
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
        g.drawString("Speed: " + String.valueOf(kart.getAcceleration() * kart.getAccTime()), 500, 500);

        kart.draw(g);

        ro1.draw(g);
        co1.draw(g);

        ro1.collision(kart);

        timer.start();
 
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {
 
        kart.updateKart();
       
        //Repaints screen
        repaint();
 
    }
 
}
