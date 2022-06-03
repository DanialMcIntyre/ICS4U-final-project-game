package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map2 extends GeneralMap {

    RectangleObstacle ro1 = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK, true);
    RectangleObstacle ro2 = new RectangleObstacle(1850, 0, 100, 1080, Color.BLUE, true);
    RectangleObstacle ro3 = new RectangleObstacle(0, 0, 20, 1080, Color.CYAN, true);
    RectangleObstacle ro4 = new RectangleObstacle(0, 0, 1920, 50, Color.MAGENTA, true);
    RectangleObstacle ro5 = new RectangleObstacle(0, 1000, 1920, 50, Color.YELLOW, true);
    RectangleObstacle ro6 = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE, true);
    RectangleObstacle ro7 = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY, true);

    public void drawMap(Graphics g) {
        ro1.draw(g);
        ro2.draw(g);
        ro3.draw(g);
        ro4.draw(g);
        ro5.draw(g);
        ro6.draw(g, startLineImg);
        ro7.draw(g);
    }

    public void checkCollision(Kart kart) {
        ro1.collision(kart);
        ro2.collision(kart);
        ro3.collision(kart);
        ro4.collision(kart);
        ro5.collision(kart);
        ro6.collision(kart);
        ro7.collision(kart);
        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        if (ro1.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro2.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro3.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro4.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro5.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro7.getIsCollided()) {
            checkPointHit = true;
        }

        if (ro6.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }

    }
    
}
