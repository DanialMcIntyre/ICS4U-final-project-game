package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;

import src.maps.*;
import src.*;

public class Game {

    public Map1 map1 = new Map1();
    public Map2 map2 = new Map2();
    public Map3 map3 = new Map3();
    public Map4 map4 = new Map4();
    public Map5 map5 = new Map5();
    public Map6 map6 = new Map6();

    boolean visible = false;

    public BufferedImage checkMark;

    public void drawGame(Graphics g, Kart kart, int mapNum, GameTime inGameTime, Point p, boolean mouseClicked) {
        
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(7));

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1920, 1080);

        //Draws map
        switch (mapNum) {
            case 0:
                map1.drawMap(g);
                break;  
            case 1:
                map2.drawMap(g);
                break;  
            case 2:
                map3.drawMap(g);
                break;  
            case 3:
                map4.drawMap(g);
                break;
            case 4:
                map5.drawMap(g);
                break;
            case 5:
                map6.drawMap(g);
                break;    
        }

        //Draws UI
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.setFont(new Font("Georgia", Font.PLAIN, 24));
        g.drawString("Laps Completed: " + String.valueOf(GeneralMap.lapCount), 25, 50);
        g.drawString("Elapsed Time: " + String.format("%.02f", inGameTime.getCurrentTime()), 250, 50);
        g.drawString("Speed: " + String.format("%.02f", kart.getAccTime() * kart.getAcceleration() / kart.getTractionLevel()), 500, 50);

        //Hit box
        g.drawString("Show Hitbox :", 1650, 50);
        g.drawRoundRect(1825, 25, 50, 50, 15, 15);
        if (p.getX() > 1825 && p.getX() < 1875 && p.getY() > 25 && p.getY() < 75 && mouseClicked) {
            visible = !visible;
        }

        //Draws kart
        kart.draw(g);

        if (visible) {
            g.setColor(new Color(255, 255, 255, 150));
            g.fillRect(kart.getXPos(), kart.getYPos(), kart.getHeight(), kart.getWidth());
            g.drawImage(checkMark, 1800, 0, 100, 100, null);
        }

        g2.setStroke(oldStroke);

    }
    
}
