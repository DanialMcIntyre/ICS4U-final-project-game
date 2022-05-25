import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements ActionListener {

    //Declaring variables
    Timer timer = new Timer(1, this);

    private BufferedImage background;
    private BufferedImage kart;
    
    public GamePanel() {

        //Getting images
        try {

            background = ImageIO.read(getClass().getResourceAsStream("images/misc/dirt.png"));
            kart = ImageIO.read(getClass().getResourceAsStream("images/misc/kart.png"));

        } catch (IOException e) {

            e.printStackTrace();    

        }

    }

    //Draw stuff of screen
    public void paint(Graphics g) {

        g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
        g.drawString(String.valueOf("poggywoggy"), 500, 500);

        g.drawImage(background, 100, 100, 200, 200, null);
        g.drawImage(kart, 100, 700, 400, 200, null);
        timer.start();

    }

    //Game loop
    public void actionPerformed(ActionEvent e) {
        
        //Repaints screen
        repaint();

    }

}