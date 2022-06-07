package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map2 extends GeneralMap {

    RectangleObstacle ro1 = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK);
    RectangleObstacle ro2 = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE);
    RectangleObstacle ro3 = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY);

    public void drawMap(Graphics g) {
        this.drawBorder(g);
        ro1.draw(g, border);
        ro2.draw(g, startLineImg);
        ro3.draw(g);
    }

    public void checkCollision(Kart kart) {
        this.borderCollision(kart);
        ro1.collision(kart);
        ro2.collision(kart);
        ro3.collision(kart);
        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        this.onBorderCollision(kart);

        if (ro1.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro3.getIsCollided()) {
            checkPointHit = true;
        }

        if (ro2.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }

    }
    
}
