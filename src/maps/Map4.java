package src.maps;

import java.awt.*;

import src.Kart;
import src.GameTime;
import src.obstacles.*;

public class Map4 extends GeneralMap {

    RectangleObstacle wall = new RectangleObstacle(1200, 0, 50, 400, Color.BLACK);
    RectangleObstacle wall2 = new RectangleObstacle(300, 300, 600, 450, Color.BLACK);
    RectangleObstacle wall3 = new RectangleObstacle(850, 350, 50, 400, Color.BLACK);
    RectangleObstacle wall4 = new RectangleObstacle(300, 700, 1300, 50, Color.BLACK);
    RectangleObstacle wall5 = new RectangleObstacle(1550, 300, 50, 400, Color.BLACK);
    CircleObstacle dirt = new CircleObstacle(200, 200, 300, 300, Color.GRAY);
    RectangleObstacle boost = new RectangleObstacle(1300, 825, 200, 50, Color.RED);
    RectangleObstacle finish = new RectangleObstacle(800, 0, 50, 300, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 750, 50, 300, Color.LIGHT_GRAY);

    //Draws map
    public void drawMap(Graphics g) {

        dirt.draw(g);
        wall.draw(g, border);
        wall2.draw(g, border);
        wall3.draw(g, border);
        wall4.draw(g, border);
        wall5.draw(g, border);
        boost.draw(g);
        finish.draw(g, startLineImg);

        this.drawBorder(g);
    }

    //Checks collision of obstacles
    public void checkCollision(Kart kart, GameTime iGT) {

        this.borderCollision(kart);
        wall.collision(kart);
        wall2.collision(kart);
        wall3.collision(kart);
        wall4.collision(kart);
        wall5.collision(kart);
        dirt.collision(kart);
        boost.collision(kart);

        finish.collision(kart);
        cp.collision(kart);

        onCollision(kart, iGT);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart, GameTime iGT) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish, iGT);

        wallCollision(wall, kart);
        wallCollision(wall2, kart);
        wallCollision(wall3, kart);
        wallCollision(wall4, kart);
        wallCollision(wall5, kart);
        dirtCollision(dirt, kart, 3);
        boostCollision(boost, kart, 15, 1.0);
    }
    
}
