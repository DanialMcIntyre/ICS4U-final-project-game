package src;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import src.obstacles.*;

import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    Main main = new Main();

    //Timers
    final int framerate = 100;
    Timer timer = new Timer(1000 / framerate, this);
    GameTime inGameTime = new GameTime();

    private BufferedImage kartImg;
    private BufferedImage startLineImg;
    private int lapCount = 0;
    private boolean checkPointHit = false;
 
    //Objects
    Kart kart;
    RectangleObstacle checkeredLine;

    RectangleObstacle ro1 = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK, true);
    RectangleObstacle ro2 = new RectangleObstacle(1000, 250, 200, 600, Color.DARK_GRAY, true);
    RectangleObstacle checkPointLine = new RectangleObstacle(300, 600, 50, 250, Color.MAGENTA, true);
    CircleObstacle co1 = new CircleObstacle(100, 200, 50, 100, Color.BLUE, true);
   
    public GamePanel() {
 
        //Getting images
        try {
 
            kartImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/kart.png"));
            startLineImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/startLine.png"));
 
            kart = new Kart(100, 100, 0, 0, 0, kartImg);
            checkeredLine = new RectangleObstacle(300, 250, 50, 250, Color.WHITE, true, startLineImg);
 
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
        g.drawString("Laps Completed: " + String.valueOf(lapCount), 25, 25);
        g.drawString("Elapsed Time: " + String.format("%.02f", inGameTime.getCurrentTime()), 250, 25);

        //Draws obstacles
        ro1.draw(g);
        ro2.draw(g);
        checkeredLine.draw(g);
        checkPointLine.draw(g);
        co1.draw(g);

        //Draws kart
        kart.draw(g);

        timer.start();
 
    }

    public void wonGame() {
        //Do we plan to create a new screen and such?
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {
 
        //Checks collision for obstacles
        ro1.collision(kart);
        ro2.collision(kart);
        checkPointLine.collision(kart);
        checkeredLine.collision(kart);

        onCollision();

        //Updates kart position
        kart.updateKart();

        if (lapCount == 5) {
            wonGame();
        }

        //Repaints screen
        repaint();
 
    }

    //Does stuff when collision occur
    public void onCollision() {

        if (ro1.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro2.getIsCollided()) {
            kart.setTractionLevel(2);
        } else {
            kart.setTractionLevel(1);
        }

        if (checkPointLine.getIsCollided()) {
            checkPointHit = true;
        }

        if (checkeredLine.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }

    }
 
}
