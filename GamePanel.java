import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

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
        g.drawString("Speed: " + String.valueOf(kart.moveKartAmount(3, kart.getAccTime(), kart.getAngle())), 500, 500);

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

    /*
    **************
    Event Listener
    **************
    */

    public void keyPressed(KeyEvent e) {

        //Move forward
        if (e.getKeyCode() == KeyEvent.VK_W) {
            kart.setIsAccelerating(true);
            if (kart.getAccTime() < 7) {
                kart.setAccTime(kart.getAccTime() + 1);  
            }
            if (kart.getAccTime() > 7) {
                kart.setAccTime(7);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (kart.getAngle() == 360) {
                kart.setAngle(1);
            } else {
                kart.setAngle(kart.getAngle() + 1);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (kart.getAngle() == 1) {
                kart.setAngle(360);
            } else {
                kart.setAngle(kart.getAngle() - 1);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            kart.setIsAccelerating(false);
        }
    }

}