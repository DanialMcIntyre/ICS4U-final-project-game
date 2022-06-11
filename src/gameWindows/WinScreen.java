package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WinScreen extends GeneralWindow{
    
    public void drawWinScreen(Graphics g, BufferedImage kart) {

        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(7));

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {1140, 1740, 1780, 1100};
        int yPoly[] = {785, 785, 945, 945};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        g.setColor(Color.CYAN);
        g.fillPolygon(p1);

        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g.drawString("Main Menu", 1300, 890);

        xPoly = new int[]{140, 820, 780, 180};
        yPoly = new int[]{150, 150, 850, 850};
        Polygon p2 = new Polygon(xPoly, yPoly, 4);
        g.setColor(Color.CYAN);
        g.fillPolygon(p2);
        g.setColor(Color.BLACK);
        g.drawPolygon(p2);

        g.fillRect(160, 275, 640, 3);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 78));
        g.drawString("Laps Complete", 245, 240);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        g.drawString("Best Lap: ", 180, 375);
        g.drawString("Best All Time Lap: ", 190, 500);
        g.drawString("Completion Time: ", 200, 625);
        g.drawString("Best Completion: ", 210, 750);

        g.drawImage(kart, (int)(1440 - (kart.getWidth()*.75)), (int)(500 - (kart.getHeight()*1.25)), (int)(kart.getWidth()*1.5), (int)(kart.getHeight()*1.5), null);

        g2.setStroke(oldStroke);

    }

}
