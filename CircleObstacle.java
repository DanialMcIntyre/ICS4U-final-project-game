import java.awt.*;

public class CircleObstacle extends Obstacle {

    public CircleObstacle(int x, int y, int w, int h, Color c, boolean t) {
        super(x, y, w, h, c, t);
    }

    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }

}