package src.gameWindows;

import java.awt.*;

import src.maps.*;
import src.*;

public class Game {

    public Map1 map1 = new Map1();
    public Map2 map2 = new Map2();

    public void drawGame(Graphics g, Kart kart, int mapNum, GameTime inGameTime) {

        //Draws UI
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1920, 1080);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Speed: " + String.valueOf(Math.round((kart.getAcceleration() * kart.getAccTime()) / kart.getTractionLevel())), 500, 500);
        g.setFont(new Font("Georgia", Font.PLAIN, 24));
        g.drawString("Laps Completed: " + String.valueOf(GeneralMap.lapCount), 25, 100);
        g.drawString("Elapsed Time: " + String.format("%.02f", inGameTime.getCurrentTime()), 250, 100);

        //Draws map
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

    }
    
}
