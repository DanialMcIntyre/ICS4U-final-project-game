package src.maps;

import java.awt.*;

import src.Kart;
import src.GameTime;
import src.obstacles.*;

public class Map5 extends GeneralMap {

    RectangleObstacle middle = new RectangleObstacle(200, 500, 1500, 100, Color.BLACK);
    CircleObstacle portal = new CircleObstacle(1600, 200, 150, 150, Color.BLUE);
    RectangleObstacle finish = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY);

    //Draws map
    public void drawMap(Graphics g) {

        middle.draw(g, border);
        portal.draw(g);
        finish.draw(g, startLineImg);

        this.drawBorder(g);
    }

    //Checks collision of obstacles
    public void checkCollision(Kart kart, GameTime iGT) {

        this.borderCollision(kart);
        middle.collision(kart);
        portal.collision(kart);
        finish.collision(kart);
        cp.collision(kart);

        onCollision(kart, iGT);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart, GameTime iGT) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish, iGT);

        wallCollision(middle, kart);
        portalCollision(portal, kart, 200, 700);
    }
    
}
