package src.maps;

import java.awt.image.BufferedImage;
import java.awt.*;

import src.obstacles.*;
import src.*;

public class GeneralMap {

    public static int lapCount = 0;
    public static boolean checkPointHit = false;
    
    public static BufferedImage startLineImg;
    public static BufferedImage mud;
    public static BufferedImage border;

    RectangleObstacle border1 = new RectangleObstacle(0, 0, 1980, 10, Color.BLACK);
    RectangleObstacle border2 = new RectangleObstacle(0, 0, 10, 1000, Color.BLACK);
    RectangleObstacle border3 = new RectangleObstacle(1895, 0, 10, 1000, Color.BLACK);
    RectangleObstacle border4 = new RectangleObstacle(0, 945, 1920, 10, Color.BLACK);

    public void drawBorder(Graphics g) {
        
        border1.draw(g);
        border2.draw(g);
        border3.draw(g);
        border4.draw(g);
    }

    public void borderCollision(Kart kart) {
        border1.collision(kart);
        border2.collision(kart);
        border3.collision(kart);
        border4.collision(kart);
    }

    public void onBorderCollision(Kart kart) {
        if (border1.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }
        if (border2.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }
        if (border3.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }
        if (border4.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        } 
    }
    
}
