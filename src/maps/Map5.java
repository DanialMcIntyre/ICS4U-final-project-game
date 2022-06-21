package src.maps;

import java.awt.*;

import src.Kart;
import src.GameTime;
import src.obstacles.*;

public class Map5 extends GeneralMap {

    CircleObstacle portal1 = new CircleObstacle(1600, 450, 150, 150, Color.BLUE);
    CircleObstacle portal2 = new CircleObstacle(1600, 500, 150, 150, Color.BLUE);
    CircleObstacle spawn = new CircleObstacle(100, 700, 150, 150, Color.MAGENTA);
    CircleObstacle spawn2 = new CircleObstacle(100, 300, 150, 150, Color.MAGENTA);

    RectangleObstacle middle = new RectangleObstacle(0, 500, 1900, 100, Color.BLACK);

    RectangleObstacle mud1 = new RectangleObstacle(1300, 200, 200, 300, Color.BLACK);

    RectangleObstacle speed1 = new RectangleObstacle(600, 700, 150, 50, Color.RED);
    RectangleObstacle speed2 = new RectangleObstacle(1200, 850, 150, 50, Color.RED);

    RectangleObstacle finish = new RectangleObstacle(1000, 0, 50, 500, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(1000, 600, 50, 500, Color.LIGHT_GRAY);

    //Draws map
    public void drawMap(Graphics g) {

        portal1.draw(g);
        portal2.draw(g);
        spawn.draw(g);
        spawn2.draw(g);
        middle.draw(g, border);
        mud1.draw(g, mud);
        speed1.draw(g);
        speed2.draw(g);
        finish.draw(g, startLineImg);

        this.drawBorder(g);
    }

    //Checks collision of obstacles
    public void checkCollision(Kart kart, GameTime iGT) {

        this.borderCollision(kart);
        middle.collision(kart);
        mud1.collision(kart);
        portal1.collision(kart);
        portal2.collision(kart);
        speed1.collision(kart);
        speed2.collision(kart);
        finish.collision(kart);
        cp.collision(kart);

        onCollision(kart, iGT);
    }

    //Does stuff when collision occur
    public void onCollision(Kart kart, GameTime iGT) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish, iGT);

        wallCollision(middle, kart);
        dirtCollision(mud1, kart, 2);
        boostCollision(speed1, kart, 20, 0.5);
        boostCollision(speed2, kart, 20, 0.5);
        portalCollision(portal1, kart, 100, 700);
        portalCollision(portal2, kart, 100, 300);
    }
    
}
