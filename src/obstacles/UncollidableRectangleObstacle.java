package src.obstacles;

import java.awt.*;

import src.*;

public class UncollidableRectangleObstacle extends Obstacle {

    public UncollidableRectangleObstacle(int x, int y, int w, int h, Color c, boolean t) {
        super(x, y, w, h, c, t);
    }

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }

    public void collision(Kart k) {
        k.setTractionLevel(1);
            for (int i = k.getXPos(); i < k.getXPos() + k.getWidth(); i++) {
                if (i > this.getXPos() && i < this.getXPos() + this.getWidth()) {
                    for (int n = k.getYPos(); n < k.getYPos() + k.getHeight(); n ++) {
                        if (n > this.getYPos() && n < this.getYPos() + this.getHeight()) {
                            k.setTractionLevel(2);
                        }
                    }
                }
            }
    }
}