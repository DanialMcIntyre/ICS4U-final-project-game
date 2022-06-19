package src.maps;

import java.awt.*;

import src.Kart;
import src.GameTime;
import src.obstacles.*;

public class Map6 extends GeneralMap{

    RectangleObstacle finish = new RectangleObstacle(1440, 200, 50, 150, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(480, 800, 50, 150, Color.BLACK);
    
    public void drawMap(Graphics g) {

        this.drawBorder(g);

        finish.draw(g, startLineImg);
        cp.draw(g);

    }

    public void checkCollision(Kart kart, GameTime iGT) {

        this.borderCollision(kart);

        finish.collision(kart);
        cp.collision(kart);

        onCollision(kart, iGT);

    }

    public void onCollision(Kart kart, GameTime iGT) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish, iGT);

    }

}
