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
        wallCollision(border1, kart);
        wallCollision(border2, kart);
        wallCollision(border3, kart);
        wallCollision(border4, kart); 
    }

    public void finishLineLogic(RectangleObstacle cp, RectangleObstacle finish) {
        
        if (cp.getIsCollided()) {
            checkPointHit = true;
        }

        if (finish.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }
    }

    public void wallCollision(RectangleObstacle wall, Kart kart) {
        if (wall.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }
    }
    
}
