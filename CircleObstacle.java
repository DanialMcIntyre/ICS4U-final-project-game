
import java.awt.*;

public class CircleObstacle extends Obstacle {

    public CircleObstacle(int x, int y, int w, int h, boolean t) {
        super(x, y, w, h, t);
    }

    public void draw(Graphics g) {
        g.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }

}