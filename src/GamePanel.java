package src;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import src.maps.*;
import src.windows.*;

import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    Main main = new Main();

    //Timers
    public final int framerate = 100;
    public Timer timer = new Timer(1000 / framerate, this);
    public GameTime inGameTime = new GameTime();

    //Images
    public BufferedImage[] kartImg = new BufferedImage[9];

    //Game stuff
    public int windowNum = 0;
    public int mapNum = 0;
    public int kartType = 8;
 
    //Objects
    public Kart kart;

    Game game = new Game();
    
    public GamePanel() {
 
        //Getting images
        try {
 
            kartImg[0] = ImageIO.read(getClass().getResourceAsStream("/images/karts/redkart.png"));
            kartImg[1] = ImageIO.read(getClass().getResourceAsStream("/images/karts/blackkart.png"));
            kartImg[2] = ImageIO.read(getClass().getResourceAsStream("/images/karts/bluekart.png"));
            kartImg[3] = ImageIO.read(getClass().getResourceAsStream("/images/karts/greenkart.png"));
            kartImg[4] = ImageIO.read(getClass().getResourceAsStream("/images/karts/orangekart.png"));
            kartImg[5] = ImageIO.read(getClass().getResourceAsStream("/images/karts/pinkkart.png"));
            kartImg[6] = ImageIO.read(getClass().getResourceAsStream("/images/karts/purplekart.png"));
            kartImg[7] = ImageIO.read(getClass().getResourceAsStream("/images/karts/tealkart.png"));
            kartImg[8] = ImageIO.read(getClass().getResourceAsStream("/images/karts/yellowkart.png"));

            GeneralMap.mud = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/mud.png"));
            GeneralMap.border = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/border.png"));
            GeneralMap.startLineImg = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/startLine.png"));
 
            kart = new Kart(100, 100, 0, 0, 0, kartImg[kartType]);
 
        } catch (IOException e) {
 
            e.printStackTrace();    
 
        }
 
    }
 
    //Draw stuff of screen
    public void paint(Graphics g) {
 
        //Clears screen
        super.paint(g);

        switch(windowNum) {
            case 0:
                game.drawGame(g, kart, mapNum, inGameTime);
                break;
        }

        timer.start();
 
    }

    public void wonGame() {
        //Do we plan to create a new screen and such?
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {

        //Updates kart position
        kart.updateKart();

        switch (mapNum) {
            case 0:
                game.map1.checkCollision(kart);
                break;
            case 1:
                game.map2.checkCollision(kart);
                break;
        }

        if (GeneralMap.lapCount == 5) {
            wonGame();
        }

        //Repaints screen
        repaint();
 
    }
 
}
