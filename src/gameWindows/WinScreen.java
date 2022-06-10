package src.gameWindows;

import java.awt.*;

public class WinScreen extends GeneralWindow{
    
    public void drawWinScreen(Graphics g) {

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {1840, 1860, 1420, 1440};
        int yPoly[] = {785, 945, 945, 785};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        g.setColor(Color.CYAN);
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g.drawString("Main Menu", 1500, 905);

    }

}
