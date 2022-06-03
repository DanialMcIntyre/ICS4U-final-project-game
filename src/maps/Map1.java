package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map1 extends GeneralMap {

    RectangleObstacle ro1 = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK, true);
    RectangleObstacle ro2 = new RectangleObstacle(1000, 250, 200, 600, Color.DARK_GRAY, true);
    RectangleObstacle checkPointLine = new RectangleObstacle(300, 600, 50, 250, Color.MAGENTA, true);
    RectangleObstacle checkeredLine = new RectangleObstacle(300, 250, 50, 250, Color.WHITE, true);
    CircleObstacle co1 = new CircleObstacle(100, 200, 50, 100, Color.BLUE, true);

    public void drawMap(Graphics g) {
        //Draws obstacles
        ro1.draw(g);
        ro2.draw(g);
        checkeredLine.draw(g, startLineImg);
        checkPointLine.draw(g);
        co1.draw(g);

    }

    public void checkCollision(Kart kart) {
        //Checks collision for obstacles
        ro1.collision(kart);
        ro2.collision(kart);
        checkPointLine.collision(kart);
        checkeredLine.collision(kart); 
        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        if (ro1.getIsCollided() && !(kart.getIsDeccelerating())) {
            kart.setAccTime(0);
        }

        if (ro2.getIsCollided()) {
            kart.setTractionLevel(2);
        } else {
            kart.setTractionLevel(1);
        }

        if (checkPointLine.getIsCollided()) {
            checkPointHit = true;
        }

        if (checkeredLine.getIsCollided() && checkPointHit) {
            lapCount += 1;
            checkPointHit = false;
        }

    }
    
}
