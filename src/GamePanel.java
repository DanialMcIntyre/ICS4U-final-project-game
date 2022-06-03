package src;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import src.maps.*;

import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    Main main = new Main();

    //Timers
    final int framerate = 100;
    Timer timer = new Timer(1000 / framerate, this);
    GameTime inGameTime = new GameTime();

    //Images
    private BufferedImage kartImg;

    //Game stuff
    public int mapNum = 1;
 
    //Objects
    Kart kart;

    Map1 map1 = new Map1();
    Map2 map2 = new Map2();
    
    public GamePanel() {
 
        //Getting images
        try {
 
            kartImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/kart.png"));
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

        //Background
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1920, 1080);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Speed: " + String.valueOf(Math.round((kart.getAcceleration() * kart.getAccTime()) / kart.getTractionLevel())), 500, 500);
        g.setFont(new Font("Georgia", Font.PLAIN, 24));
        g.drawString("Laps Completed: " + String.valueOf(GeneralMap.lapCount), 25, 100);
        g.drawString("Elapsed Time: " + String.format("%.02f", inGameTime.getCurrentTime()), 250, 100);

        switch (mapNum) {
            case 0:
                map1.drawMap(g);
                break;
            case 1:
                map2.drawMap(g);
                break;
                
        }

        //Draws kart
        kart.draw(g);

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
                map1.checkCollision(kart);
                break;
            case 1:
                map2.checkCollision(kart);
                break;
        }

        if (GeneralMap.lapCount == 5) {
            wonGame();
        }

        //Repaints screen
        repaint();
 
    }
 
}
