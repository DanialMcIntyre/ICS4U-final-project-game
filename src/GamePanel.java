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
    public BufferedImage kartImg;

    //Game stuff
    public int windowNum = 0;
    public int mapNum = 0;
 
    //Objects
    public Kart kart;

    Game game = new Game();
    
    public GamePanel() {
 
        //Getting images
        try {
 
            kartImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/kart.png"));

            GeneralMap.mud = ImageIO.read(getClass().getResourceAsStream("/images/misc/mud.png"));
            GeneralMap.border = ImageIO.read(getClass().getResourceAsStream("/images/misc/border.png"));
            GeneralMap.startLineImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/startLine.png"));
 
            kart = new Kart(100, 100, 0, 0, 0, kartImg);
 
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
