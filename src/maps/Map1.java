package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map1 extends GeneralMap {

    RectangleObstacle middle = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK);
    RectangleObstacle finish = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY);

    public void drawMap(Graphics g) {
        this.drawBorder(g);
        middle.draw(g, border);
        finish.draw(g, startLineImg);
    }

    public void checkCollision(Kart kart) {
        this.borderCollision(kart);
        middle.collision(kart);
        finish.collision(kart);
        cp.collision(kart);
        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish);

        if (middle.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

    }
    
}
