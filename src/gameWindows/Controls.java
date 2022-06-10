package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Controls extends GeneralWindow {

    public BufferedImage mouseImg;
    public BufferedImage wasdImg;
    public BufferedImage arrowsImg;

    public void drawControls(Graphics g) {

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {720, 1200, 1220, 700};
        int yPoly[] = {800, 800, 950, 950};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        g.setColor(Color.CYAN);
        g.fillPolygon(p1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g.drawString("Main Menu", 810, 905);

        g.setFont(new Font("Impact", Font.PLAIN, 64));
        g.drawString("Controls", 850, 200);

        g.setColor(new Color(255, 255, 255, 175));
        g.fillRoundRect(260, 255, 450, 500, 15, 15);
        g.fillRoundRect(1175, 255, 545, 500, 15, 15);

        g.drawImage(mouseImg, 350, 475, (int)(mouseImg.getWidth()*.5), (int)(mouseImg.getHeight()*.5), null);
        g.drawImage(arrowsImg, 1180, 555, (int)(arrowsImg.getWidth()*.5), (int)(arrowsImg.getHeight()*.45), null);
        g.drawImage(wasdImg, 1460, 590, (int)(wasdImg.getWidth()*.9),(int)(wasdImg.getHeight()*.9) ,null);

        g.setFont(new Font("Impact", Font.PLAIN, 38));
        g.setColor(new Color(24, 134, 153));
        g.drawString("Use your mouse to interact", 275, 300);
        g.drawString("with buttons and", 360, 350);
        g.drawString("various game elements", 305, 400);
        g.fillRect((int)(1920*0.75), 0, 1, 1080);

        g.drawString("To control the car use the arrow", 1200, 300);
        g.drawString("keys. Change direction using the", 1195, 350);
        g.drawString("left and right arrows or ‘a’ and ‘d’,", 1195, 400);
        g.drawString("and accelerate with the up arrow", 1195, 450);
        g.drawString("key or ‘w’ and finally brake using", 1198, 500);
        g.drawString("the down arrow or ‘s’.", 1275, 550);


    }

}
