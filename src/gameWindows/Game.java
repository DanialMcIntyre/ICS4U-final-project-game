package src.gameWindows;

import java.awt.*;

import src.maps.*;
import src.*;

public class Game {

    public Map1 map1 = new Map1();
    public Map2 map2 = new Map2();
    public Map3 map3 = new Map3();
    public Map4 map4 = new Map4();
    public Map5 map5 = new Map5();

    public void drawGame(Graphics g, Kart kart, int mapNum, GameTime inGameTime) {
        
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
        }

        //Draws UI
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Speed: " + String.valueOf(Math.round((kart.getAcceleration() * kart.getAccTime()) / kart.getTractionLevel())), 500, 500);
        g.setFont(new Font("Georgia", Font.PLAIN, 24));
        g.drawString("Laps Completed: " + String.valueOf(GeneralMap.lapCount), 25, 100);
        g.drawString("Elapsed Time: " + String.format("%.02f", inGameTime.getCurrentTime()), 250, 100);

        //Draws kart
        kart.draw(g);

        g.setColor(new Color(255, 255, 255, 150));
        g.fillRect(kart.getXPos(), kart.getYPos(), kart.getHeight(), kart.getWidth());

    }
    
}
