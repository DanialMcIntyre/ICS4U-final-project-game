package src.obstacles;

import java.awt.*;
import java.awt.image.BufferedImage;

import src.*;

public class RectangleObstacle extends Obstacle {

    private boolean isCollided = false;
    private BufferedImage obstImg;

    public RectangleObstacle(int x, int y, int w, int h, Color c, boolean t) {
        super(x, y, w, h, c, t);
    }

    public RectangleObstacle(int x, int y, int w, int h, Color c, boolean t, BufferedImage img) {
        super(x, y, w, h, c, t);
        obstImg = img;
    }

    public boolean getIsCollided() {
        return this.isCollided;
    }

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
        if (obstImg != null) {
            g.drawImage(obstImg, this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight(), null);
        }
    }

    public void collision(Kart k) {

        if (!(k.getIsDeccelerating())) {
            this.isCollided = false;
            for (int i = k.getXPos(); i < k.getXPos() + k.getWidth(); i++) {
                if (i > this.getXPos() && i < this.getXPos() + this.getWidth()) {
                    for (int n = k.getYPos(); n < k.getYPos() + k.getHeight(); n ++) {
                        if (n > this.getYPos() && n < this.getYPos() + this.getHeight()) {
                            this.isCollided = true;
                        } 
                    }
                } 
            }
        } 
    }
}