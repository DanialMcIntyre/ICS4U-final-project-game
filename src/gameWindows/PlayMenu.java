package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;
import src.GameTime;
import src.Kart;

public class PlayMenu extends GeneralWindow {

    private int kartNum = 0;
    
    public void drawPlayMenu(Graphics g, BufferedImage[] karts, Point p, boolean mouseClicked, GameTime iGT, Kart kart) {

        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(7));

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {1880, 1780, 1000, 1100};
        int yPoly[] = {785, 945, 945, 785};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        if (p1.contains(p)) {
            g.setColor(new Color(24, 134, 153));

            if (mouseClicked) {
                kart.setImage(karts[kartNum]);
                iGT.startTimer();
                windowNum = 0;
            }
        } else {
            g.setColor(Color.CYAN);
        }
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 78));
        g.drawString("Let's Race", 1280, 890);

        g.setColor(new Color(255, 255, 255, 175));
        g.fillRoundRect(100, 100, 760, 800, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 100, 760, 800, 30, 30);
        g.fillRect(112, 200, 736, 3);
        
        g.drawString("Choose Your Kart", 190, 180);

        g.drawImage(karts[0], (int)((760*.25) - (karts[0].getWidth()*.5) + 150), (int)((800*.25) - (karts[0].getHeight()*.5) + 225), (int)(karts[0].getWidth()*.5), (int)(karts[0].getHeight()*.5), null);
        g.drawImage(karts[1], (int)((760*.5) - (karts[1].getWidth()*.5) + 175), (int)((800*.25) - (karts[1].getHeight()*.5) + 225), (int)(karts[1].getWidth()*.5), (int)(karts[1].getHeight()*.5), null);
        g.drawImage(karts[2], (int)((760*.75) - (karts[2].getWidth()*.5) + 200), (int)((800*.25) - (karts[2].getHeight()*.5) + 225), (int)(karts[2].getWidth()*.5), (int)(karts[2].getHeight()*.5), null);
        g.drawImage(karts[3], (int)((760*.25) - (karts[3].getWidth()*.5) + 150), (int)((800*.5) - (karts[3].getHeight()*.5) + 225), (int)(karts[3].getWidth()*.5), (int)(karts[3].getHeight()*.5), null);
        g.drawImage(karts[4], (int)((760*.5) - (karts[4].getWidth()*.5) + 175), (int)((800*.5) - (karts[4].getHeight()*.5) + 225), (int)(karts[4].getWidth()*.5), (int)(karts[4].getHeight()*.5), null);
        g.drawImage(karts[5], (int)((760*.75) - (karts[5].getWidth()*.5) + 200), (int)((800*.5) - (karts[5].getHeight()*.5) + 225), (int)(karts[5].getWidth()*.5), (int)(karts[5].getHeight()*.5), null);
        g.drawImage(karts[6], (int)((760*.25) - (karts[6].getWidth()*.5) + 150), (int)((800*.75) - (karts[6].getHeight()*.5) + 225), (int)(karts[6].getWidth()*.5), (int)(karts[6].getHeight()*.5), null);
        g.drawImage(karts[7], (int)((760*.5) - (karts[7].getWidth()*.5) + 175), (int)((800*.75) - (karts[7].getHeight()*.5) + 225), (int)(karts[7].getWidth()*.5), (int)(karts[7].getHeight()*.5), null);
        g.drawImage(karts[8], (int)((760*.75) - (karts[8].getWidth()*.5) + 200), (int)((800*.75) - (karts[8].getHeight()*.5) + 225), (int)(karts[8].getWidth()*.5), (int)(karts[8].getHeight()*.5), null);

        if (p.getX() > 179 && p.getX() < 340 && p.getY() > 264 && p.getY() < 425) {
            g.drawRoundRect(179, 264, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 0;
            }
        } else if (p.getX() > 394 && p.getX() < 555 && p.getY() > 264 && p.getY() < 425) {
            g.drawRoundRect(394, 264, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 1;
            }
        } else if (p.getX() > 609 && p.getX() < 770 && p.getY() > 264 && p.getY() < 425) {
            g.drawRoundRect(609, 264, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 2;
            }
        } else if (p.getX() > 179 && p.getX() < 340 && p.getY() > 464 && p.getY() < 625) {
            g.drawRoundRect(179, 464, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 3;
            }
        } else if (p.getX() > 394 && p.getX() < 555 && p.getY() > 464 && p.getY() < 625) {
            g.drawRoundRect(394, 464, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 4;
            }
        } else if (p.getX() > 609 && p.getX() < 770 && p.getY() > 464 && p.getY() < 625) {
            g.drawRoundRect(609, 464, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 5;
            }
        } else if (p.getX() > 179 && p.getX() < 340 && p.getY() > 664 && p.getY() < 825) {
            g.drawRoundRect(179, 664, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 6;
            }
        } else if (p.getX() > 394 && p.getX() < 555 && p.getY() > 664 && p.getY() < 825) {
            g.drawRoundRect(394, 664, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 7;
            }
        } else if (p.getX() > 609 && p.getX() < 770 && p.getY() > 664 && p.getY() < 825) {
            g.drawRoundRect(609, 664, 161, 161, 15, 15);
            if (mouseClicked) {
                kartNum = 8;
            }
        }

        g.drawImage(karts[kartNum], (int)(1440 - (karts[kartNum].getWidth()*.75)), (int)(500 - (karts[kartNum].getHeight()*1.25)), (int)(karts[kartNum].getWidth()*1.5), (int)(karts[kartNum].getHeight()*1.5), null);

        g2.setStroke(oldStroke);

    }

    public int getKartNum() {
        return kartNum;
    }
}
