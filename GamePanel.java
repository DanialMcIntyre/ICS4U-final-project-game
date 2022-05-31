import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    final int framerate = 100;
    Timer timer = new Timer(1000 / framerate, this);
 
    private BufferedImage background;
    private BufferedImage kartImg;
 
    Kart kart;
   
    public GamePanel() {
 
        //Getting images
        try {
 
            background = ImageIO.read(getClass().getResourceAsStream("images/misc/dirt.png"));
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
 
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Speed: " + String.valueOf(kart.getAcceleration() * kart.getAccTime()), 500, 500);
 
        g.drawImage(background, 100, 100, 200, 200, null);
       
        kart.draw(g);
   
        timer.start();
 
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {
 
        kart.updateKart();
       
        //Repaints screen
        repaint();
 
    }
 
}
