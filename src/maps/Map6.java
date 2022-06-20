package src.maps;

import java.awt.*;

import src.Kart;
import src.GameTime;
import src.obstacles.*;

public class Map6 extends GeneralMap{

    RectangleObstacle finish = new RectangleObstacle(1440, 50, 50, 250, Color.WHITE);
    RectangleObstacle cp = new RectangleObstacle(480, 625, 50, 300, Color.BLACK);

    RectangleObstacle dirt1 = new RectangleObstacle(380, 600, 1035, 350, Color.BLACK);

    CircleObstacle crc1 = new CircleObstacle(-75, -75, 300, 300, new Color(3, 99, 14));
    CircleObstacle crc2 = new CircleObstacle(-75, 775, 300, 300, new Color(3, 99, 14));
    CircleObstacle crc3 = new CircleObstacle(1695, -75, 300, 300, Color.LIGHT_GRAY);
    CircleObstacle crc4 = new CircleObstacle(1695, 775, 300, 300, Color.LIGHT_GRAY);
    CircleObstacle crc5 = new CircleObstacle(1745, 125, 200, 200, Color.LIGHT_GRAY);
    CircleObstacle crc6 = new CircleObstacle(1745, 675, 200, 200, Color.LIGHT_GRAY);
    CircleObstacle crc7 = new CircleObstacle(1785, 265, 150, 150, Color.LIGHT_GRAY);
    CircleObstacle crc8 = new CircleObstacle(1785, 600, 150, 150, Color.LIGHT_GRAY);
    CircleObstacle crc9 = new CircleObstacle(1000, 250, 500, 500, Color.LIGHT_GRAY);
    CircleObstacle crc10 = new CircleObstacle(1375, 275, 125, 125, Color.LIGHT_GRAY);
    CircleObstacle crc11 = new CircleObstacle(1525, -75, 200, 200, Color.LIGHT_GRAY);
    CircleObstacle crc12 = new CircleObstacle(1525, 850, 200, 200, Color.LIGHT_GRAY);
    CircleObstacle crc13 = new CircleObstacle(660, 750, 350, 350, new Color(3, 99, 14));

    RectangleObstacle rect1 = new RectangleObstacle(1795, 300, 125, 400, Color.LIGHT_GRAY);
    RectangleObstacle rect2 = new RectangleObstacle(200, 0, 1350, 50, new Color(3, 99, 14));
    RectangleObstacle rect3 = new RectangleObstacle(200, 915, 1350, 50, new Color(3, 99, 14));
    RectangleObstacle rect4 = new RectangleObstacle(480, 375, 560, 250, new Color(3, 99, 14));
    
    
    public void drawMap(Graphics g) {

        this.drawBorder(g);

        finish.draw(g, startLineImg);

        dirt1.draw(g, mud);

        cp.draw(g);

        crc3.draw(g);
        crc4.draw(g);
        crc5.draw(g);
        crc6.draw(g);
        crc7.draw(g);
        crc8.draw(g);
        rect4.draw(g);
        crc9.draw(g);
        crc10.draw(g);

        rect2.draw(g);
        rect3.draw(g);

        crc11.draw(g);
        crc12.draw(g);
        crc13.draw(g);

        rect1.draw(g);

        crc1.draw(g);
        crc2.draw(g);

    }

    public void checkCollision(Kart kart, GameTime iGT) {

        this.borderCollision(kart);

        finish.collision(kart);
        cp.collision(kart);

        crc1.collision(kart);
        crc2.collision(kart);
        crc3.collision(kart);
        crc4.collision(kart);

        onCollision(kart, iGT);

    }

    public void onCollision(Kart kart, GameTime iGT) {

        this.onBorderCollision(kart);
        this.finishLineLogic(cp, finish, iGT);

        wallCollision(crc1, kart);
        wallCollision(crc2, kart);
        wallCollision(crc3, kart);
        wallCollision(crc4, kart);

    }

}
