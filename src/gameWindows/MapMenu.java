package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;

import src.Kart;

public class MapMenu extends GeneralWindow {

    public int mapNum = 0;
    int x = 900;
    int y = 200;

    public BufferedImage[] mapImgs = new BufferedImage[6];

    public void drawMapMenu(Graphics g, Point p, boolean mouseClicked, Kart kart) {

        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(7));

        g.drawImage(background, 0, 0, 1920, 1080, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 78));
        g.drawString("Choose Your Map", 670, 75);

        int xPoly[] = {1880, 1780, 1000, 1100};
        int yPoly[] = {785, 945, 945, 785};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        if (p1.contains(p)) {
            g.setColor(new Color(24, 134, 153));

            if (mouseClicked) {
                kart.setXPos(x);
                kart.setYPos(y);
                kart.setAngle(0);
                windowNum = 4;
            }
        } else {
            g.setColor(Color.CYAN);
        }
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.drawString("Next", 1355, 890);

        g.drawImage(mapImgs[0], 220, 123, 440, 300, null);
        g.drawImage(mapImgs[1], 750, 123, 440, 300, null);
        g.drawImage(mapImgs[2], 1260, 123, 440, 300, null);
        g.drawImage(mapImgs[3], 220, 456, 440, 300, null);
        g.drawImage(mapImgs[4], 750, 456, 440, 300, null);
        g.drawImage(mapImgs[5], 1260, 456, 440, 300, null);


        if (p.getX() > 220 && p.getX() < 660 && p.getY() > 123 && p.getY() < 423 && (mapNum != 0)) {
            g.drawRect(220, 123, 440, 300);
            if (mouseClicked) {
                x = 900;
                y = 200;
                mapNum = 0;
            }
        } else if (p.getX() > 750 && p.getX() < 1190 && p.getY() > 123 && p.getY() < 423 && (mapNum != 1)) {
            g.drawRect(750, 123, 440, 300);
            if (mouseClicked) {
                x = 900;
                y = 200;
                mapNum = 1;
            }
        } else if (p.getX() > 1260 && p.getX() < 1700 && p.getY() > 123 && p.getY() < 423 && (mapNum != 2)) {
            g.drawRect(1260, 123, 440, 300);
            if (mouseClicked) {
                x = 1100;
                y = 185;
                mapNum = 2;
            }
        } else if (p.getX() > 220 && p.getX() < 660 && p.getY() > 456 && p.getY() < 756 && (mapNum != 3)) {
            g.drawRect(220, 456, 440, 300);
            if (mouseClicked) {
                x = 700;
                y = 125;
                mapNum = 3;
            }
        } else if (p.getX() > 750 && p.getX() < 1190 && p.getY() > 456 && p.getY() < 756 && (mapNum != 4)) {
            g.drawRect(750, 456, 440, 300);
            if (mouseClicked) {
                x = 900;
                y = 200;
                mapNum = 4;
            }
        } else if (p.getX() > 1260 && p.getX() < 1700 && p.getY() > 456 && p.getY() < 756 && (mapNum != 5)) {
            g.drawRect(1260, 456, 440, 300);
            if (mouseClicked) {
                x = 1340;
                y = 100;
                mapNum = 5;
            }
        }

        g.setColor(new Color (181, 14, 14));

        switch (mapNum) {
            case 0:
                g.drawRect(220, 123, 440, 300);
                break;
            case 1:
                g.drawRect(750, 123, 440, 300);
                break;
            case 2:
                g.drawRect(1260, 123, 440, 300);
                break;
            case 3:
                g.drawRect(220, 456, 440, 300);
                break;
            case 4:
                g.drawRect(750, 456, 440, 300);
                break;
            case 5:
                g.drawRect(1260, 456, 440, 300);
                break;
        }   

        g2.setStroke(oldStroke);

    }

}
