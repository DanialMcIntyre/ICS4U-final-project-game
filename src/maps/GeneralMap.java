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

    //Draws border
    public void drawBorder(Graphics g) {
        border1.draw(g);
        border2.draw(g);
        border3.draw(g);
        border4.draw(g);
    }

    //Checks for border collision
    public void borderCollision(Kart kart) {
        border1.collision(kart);
        border2.collision(kart);
        border3.collision(kart);
        border4.collision(kart);
    }

    //Does stuff when collided with border
    public void onBorderCollision(Kart kart) {
        wallCollision(border1, kart);
        wallCollision(border2, kart);
        wallCollision(border3, kart);
        wallCollision(border4, kart); 
    }

    //What happens when you cross finish line
    public void finishLineLogic(RectangleObstacle cp, RectangleObstacle finish) {
        
        if (cp.getIsCollided()) {
            checkPointHit = true;
        }

        if (finish.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }
    }

    //What happens when you collide with a wall
    public void wallCollision(Obstacle wall, Kart kart) {
        if (wall.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }
    }

    //What happens when you drive on dirt
    public void dirtCollision(Obstacle wall, Kart kart, double factor) {
        if (wall.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setTractionLevel(factor);
        } else {
            kart.setTractionLevel(1);
        }
    } 

    //What happens when you drive on dirt
    public void boostCollision(Obstacle wall, Kart kart, double max, double incr) {
        if (wall.getIsCollided() && kart.getAccTime() <= max && !kart.getIsDeccelerating()) {
            kart.setAccTime(kart.getAccTime() + incr);
            kart.setIsBoosted(true);
        } else {
            kart.setAccTime(kart.getAccTime());
            kart.setIsBoosted(false);
        }
    } 

}
