package src.gameWindows;

import java.awt.*;

public class Instructions extends GeneralWindow {

    public void drawInstructions(Graphics g, Point p, boolean mouseClicked) {

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {720, 1200, 1220, 700};
        int yPoly[] = {800, 800, 950, 950};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        if (p1.contains(p)) {
            g.setColor(new Color(24, 134, 153));

            if (mouseClicked) {
                windowNum = 1;
            }

        } else {
            g.setColor(Color.CYAN);
        }
        
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g.drawString("Main Menu", 810, 905);

        g.setFont(new Font("Impact", Font.PLAIN, 64));
        g.drawString("Instructions", 800, 200);

        g.setColor(new Color(255, 255, 255, 175));
        g.fillRoundRect(460, 270, 980, 330, 15, 15);

        g.setFont(new Font("Impact", Font.PLAIN, 48));
        g.setColor(new Color(24, 134, 153));
        g.drawString("Race your car around the race track!", 585, 330);
        g.drawString("Stay on the track and avoid obstacles!", 570, 410);
        g.drawString("Complete the race as fast as you can!", 580, 490);
        g.drawString("Compete with your friends to earn the best time!", 475, 570);

    }
    
}
