package src;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.Collections;

import src.maps.*;
import src.gameWindows.*;

import javax.imageio.ImageIO;
 
public class GamePanel extends JPanel implements ActionListener {
 
    //Declaring variables
    Main main = new Main();

    //Objects
    public Kart kart;

    Game game = new Game();
    MainMenu mainMenu = new MainMenu();
    Instructions instructions = new Instructions();
    Controls controls = new Controls();
    PlayMenu playMenu = new PlayMenu();
    WinScreen winScreen = new WinScreen();
    MapMenu mapMenu = new MapMenu();

    //Timers
    public final int framerate = 100;
    public Timer timer = new Timer(1000 / framerate, this);
    public GameTime inGameTime = new GameTime();

    //Images
    public BufferedImage[] kartImg = new BufferedImage[9];

    //Game stuff
    public double compTime;

    //Mouse vars
    public boolean mouseClicked = false;
    public Point p = new Point();
    
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

            mapMenu.mapImgs[0] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map1Img.png"));
            mapMenu.mapImgs[1] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map2Img.png"));
            mapMenu.mapImgs[2] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map3Img.png"));
            mapMenu.mapImgs[3] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map4Img.png"));
            mapMenu.mapImgs[4] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map5Img.png"));
            mapMenu.mapImgs[5] = ImageIO.read(getClass().getResourceAsStream("/images/menu/Map6Img.png"));

            GeneralMap.mud = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/mud.png"));
            GeneralMap.border = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/border.png"));
            GeneralMap.startLineImg = ImageIO.read(getClass().getResourceAsStream("/images/mapparts/startLine.png"));
            GeneralWindow.background = ImageIO.read(getClass().getResourceAsStream("/images/menu/background.jpg"));
            GeneralWindow.logo = ImageIO.read(getClass().getResourceAsStream("/images/misc/turbokartmania.png"));
            controls.mouseImg = ImageIO.read(getClass().getResourceAsStream("/images/menu/mouse.png"));
            controls.wasdImg = ImageIO.read(getClass().getResourceAsStream("/images/menu/wasd.png"));
            controls.arrowsImg = ImageIO.read(getClass().getResourceAsStream("/images/menu/arrows.png"));
 
            kart = new Kart(100, 100, 0, 0, 0, kartImg[playMenu.getKartNum()]);
 
        } catch (IOException e) {
 
            e.printStackTrace();    
 
        }
 
    }
 
    //Draw stuff of screen
    public void paint(Graphics g) {
 
        //Clears screen
        super.paint(g);

        switch(GeneralWindow.windowNum) {
            case 0:
                game.drawGame(g, kart, mapMenu.mapNum, inGameTime);
                break;
            case 1:
                mainMenu.drawMainMenu(g, p, mouseClicked);
                break;
            case 2:
                instructions.drawInstructions(g, p, mouseClicked);
                break;
            case 3:
                controls.drawControls(g, p, mouseClicked);
                break;
            case 4:
                playMenu.drawPlayMenu(g, kartImg, p, mouseClicked, inGameTime, kart);
                break;
            case 5:
                winScreen.drawWinScreen(g, kartImg[playMenu.getKartNum()], p, mouseClicked, compTime);
                break;
            case 6:
                mapMenu.drawMapMenu(g, p, mouseClicked, kart);
                break;
        }

        mouseClicked = false;
        timer.start();
 
    }
 
    //Game loop
    public void actionPerformed(ActionEvent e) {

        //Updates kart position
        kart.updateKart();

        switch (mapMenu.mapNum) {
            case 0:
                game.map1.checkCollision(kart, inGameTime);
                break;
            case 1:
                game.map2.checkCollision(kart, inGameTime);
                break;
            case 2:
                game.map3.checkCollision(kart, inGameTime);
                break;
            case 3:
                game.map4.checkCollision(kart, inGameTime);
                break;
            case 4:
                game.map5.checkCollision(kart, inGameTime);
                break;
            case 5:
                game.map6.checkCollision(kart, inGameTime);
                break;
        }

        if (GeneralMap.lapCount == 5) {
            compTime = inGameTime.getCurrentTime();
            Collections.sort(GeneralMap.lapTimes);
            GeneralWindow.windowNum = 5;
        }

        //Repaints screen
        repaint();
 
    }
 
}
