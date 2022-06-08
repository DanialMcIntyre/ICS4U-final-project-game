package src.obstacles;

import java.awt.*;

import src.*;

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

    public void collision(Kart kart) {
        isCollided = false;
        if (!(kart.getIsDeccelerating())) {
            for (int r = this.getHeight() / 2; r > this.getHeight() / 4; r--) {
                for (int t = 0; t < 360; t+= 5) {

                    int x = (int)(r * Math.cos(Math.toRadians(t))) + (this.getXPos() + (this.getWidth() / 2));
                    int y = (int)(r * Math.sin(Math.toRadians(t))) + (this.getYPos() + (this.getHeight() / 2));

                    if (x > kart.getXPos() && x < kart.getXPos() + kart.getWidth()) {
                        if (y > kart.getYPos() && y < kart.getYPos() + kart.getHeight()) {
                            this.isCollided = true;
                        }
                    }

                }

            }
        }
    }

}