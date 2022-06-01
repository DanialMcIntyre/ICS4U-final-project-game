
import java.awt.*;

public class RectangleObstacle extends Obstacle {

    public RectangleObstacle(int x, int y, int w, int h, boolean t) {
        super(x, y, w, h, t);
    }

    public void draw(Graphics g) {
        g.fillRect(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }

    public void collision(Kart k) {

        if (!(k.getIsDeccelerating())) {
            for (int i = k.getXPos(); i < k.getXPos() + k.getWidth(); i++) {
                if (i > this.getXPos() && i < this.getXPos() + this.getWidth()) {
                    for (int n = k.getYPos(); n < k.getYPos() + k.getHeight(); n ++) {
                        if (n > this.getYPos() && n < this.getYPos() + this.getHeight()) {
                            k.setAccTime(0);
                        }
                    }
                }
            }
        }

    }

}