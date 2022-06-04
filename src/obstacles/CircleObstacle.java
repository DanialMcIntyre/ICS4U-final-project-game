package src.obstacles;

import java.awt.*;

public class CircleObstacle extends Obstacle {

    private boolean isCollided = false;

    public CircleObstacle(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }

    public boolean getIsCollided() {
        return this.isCollided;
    }

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }

}