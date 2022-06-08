package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map1 extends GeneralMap {

    RectangleObstacle middle = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK);
    RectangleObstacle finish = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY);

    CircleObstacle circle = new CircleObstacle(500, 200, 100, 100, Color.PINK);

    //Draws map
    public void drawMap(Graphics g) {

        this.drawBorder(g);
        middle.draw(g, border);
        finish.draw(g, startLineImg);
        circle.draw(g);

    }

    //Checks collision of obstacles
    public void checkCollision(Kart kart) {

        this.borderCollision(kart);
        middle.collision(kart);
        finish.collision(kart);
        cp.collision(kart);
        circle.collision(kart);

        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish);

        wallCollision(middle, kart);

        if (circle.getIsCollided() == true) {
            kart.setAccTime(0);
        }

    }
    
}
