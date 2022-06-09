package src.maps;

import java.awt.*;

import src.Kart;
import src.obstacles.*;

public class Map3 extends GeneralMap {

    CircleObstacle circle = new CircleObstacle(300, 175, 600, 600, Color.ORANGE);
    RectangleObstacle middle = new RectangleObstacle(400, 450, 1300, 100, Color.BLACK);
    RectangleObstacle finish = new RectangleObstacle(1200, 0, 50, 450, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 550, 50, 500, Color.LIGHT_GRAY);
    RectangleObstacle dirt = new RectangleObstacle(0, 0, 150, 1000, Color.WHITE);

    //Draws map
    public void drawMap(Graphics g) {

        middle.draw(g, border);
        circle.draw(g);
        finish.draw(g, startLineImg);
        dirt.draw(g, mud);

        this.drawBorder(g);
    }

    //Checks collision of obstacles
    public void checkCollision(Kart kart) {

        this.borderCollision(kart);
        middle.collision(kart);
        circle.collision(kart);
        finish.collision(kart);
        dirt.collision(kart);
        cp.collision(kart);

        onCollision(kart);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish);

        wallCollision(middle, kart);
        wallCollision(circle, kart);
        dirtCollision(dirt, kart, 2);
    }
    
}
