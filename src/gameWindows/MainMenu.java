package src.gameWindows;

import java.awt.*;

public class MainMenu extends GeneralWindow {

    public void drawMainMenu(Graphics g, Point p, boolean mouseClicked) {

        g.drawImage(background, 0, 0, 1920, 1080, null);
        g.drawImage(logo, (1920 / 2) - (logo.getWidth() / 2), 195, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString("Coords: " + p.getX() + ", " + p.getY(), 25, 100);

        int xPoly[] = { 720, 1200, 1220, 700 };
        int yPoly[] = { 800, 800, 950, 950 };
        Polygon p1 = new Polygon(xPoly, yPoly, 4);

        xPoly = new int[] { 280, 480, 500, 260 };
        yPoly = new int[] { 820, 820, 930, 930 };
        Polygon p2 = new Polygon(xPoly, yPoly, 4);

        xPoly = new int[] { 1440, 1640, 1660, 1420 };
        Polygon p3 = new Polygon(xPoly, yPoly, 4);

        if (p1.contains(p)) {
            g.setColor(new Color(24, 134, 153));
            g.fillPolygon(p1);

            if (mouseClicked) {
                windowNum = 4;
            }
        } else {
            g.setColor(Color.CYAN);
            g.fillPolygon(p1);
        }

        if (p2.contains(p)) {
            g.setColor(new Color(24, 134, 153));
            g.fillPolygon(p2);

            if (mouseClicked) {
                windowNum = 3;
            }
        } else {
            g.setColor(Color.CYAN);
            g.fillPolygon(p2);
        }

        if (p3.contains(p)) {
            g.setColor(new Color(24, 134, 153));
            g.fillPolygon(p3);

            if (mouseClicked) {
                windowNum = 2;
            }
        } else {
            g.setColor(Color.CYAN);
            g.fillPolygon(p3);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g.drawString("Play", 905, 890);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
        g.drawString("Controls", 320, 885);
        g.drawString("Instructions", 1460, 885);

    }

}
