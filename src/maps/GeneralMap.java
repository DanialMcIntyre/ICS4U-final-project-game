package src.maps;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class GeneralMap {

    public static int lapCount = 0;
    public static boolean checkPointHit = false;
    
    public static BufferedImage startLineImg;
    public BufferedImage mud;
    public BufferedImage border;

    public GeneralMap() {

        try {

            mud = ImageIO.read(getClass().getResourceAsStream("/images/misc/mud.png"));
            border = ImageIO.read(getClass().getResourceAsStream("/images/misc/border.png"));
            startLineImg = ImageIO.read(getClass().getResourceAsStream("/images/misc/startLine.png"));

        } catch (IOException e) {
 
            e.printStackTrace();    
 
        }
    }
    
}
