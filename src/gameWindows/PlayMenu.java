package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayMenu extends GeneralWindow {

    private int kartNum;
    
    public void drawPlayMenu(Graphics g, BufferedImage[] karts) {

        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {1880, 1780, 1000, 1100};
        int yPoly[] = {785, 945, 945, 785};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        g.setColor(Color.CYAN);
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 78));
        g.drawString("Let's Race", 1280, 890);

        g.setColor(new Color(255, 255, 255, 175));
        g.fillRoundRect(100, 100, 760, 800, 30, 30);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(7));
        g.drawRoundRect(100, 100, 760, 800, 30, 30);
        g.fillRect(112, 200, 736, 3);
        
        g.drawString("Choose Your Kart", 190, 180);

        //Probably vould use for loop but my brian is too fryed
        g.drawImage(karts[0], (int)((760*.25) - (karts[0].getWidth()*.5) + 150), (int)((800/3) - (karts[0].getHeight()*.5) + 150), (int)(karts[0].getWidth()*.5), (int)(karts[0].getHeight()*.5), null);
        g.drawImage(karts[1], (int)((760*.5) - (karts[1].getWidth()*.5) + 175), (int)((800/3) - (karts[1].getHeight()*.5) + 150), (int)(karts[1].getWidth()*.5), (int)(karts[1].getHeight()*.5), null);
        g.drawImage(karts[2], (int)((760*.75) - (karts[2].getWidth()*.5) + 200), (int)((800/3) - (karts[1].getHeight()*.5) + 150), (int)(karts[2].getWidth()*.5), (int)(karts[2].getHeight()*.5), null);

        g2.setStroke(oldStroke);

    }

    public int getKartNum() {
        return kartNum;
    }
}
