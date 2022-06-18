package src.gameWindows;

import java.awt.*;
import java.awt.image.BufferedImage;
import src.maps.GeneralMap;

import java.io.*;
import java.util.*;

public class WinScreen extends GeneralWindow {
    
    LinkedList<Double> allTimeStats = new LinkedList<Double>();

    boolean executed = false;

    public void drawWinScreen(Graphics g, BufferedImage kart, Point p, boolean mouseClicked, double cT) {

        GeneralMap.lapCount = 0;
        
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(7));

        g.drawImage(background, 0, 0, 1920, 1080, null);

        int xPoly[] = {1140, 1740, 1780, 1100};
        int yPoly[] = {785, 785, 945, 945};
        Polygon p1 = new Polygon(xPoly, yPoly, 4);
        if (p1.contains(p)) {
            g.setColor(new Color(24, 134, 153));

            if (mouseClicked) {
                
                try {
                    new PrintWriter("src/Stats.txt").close();
                    FileWriter mFW = new FileWriter("src/Stats.txt");
                    BufferedWriter writer = new BufferedWriter(mFW);
                    for (double i : allTimeStats) {
                        writer.write(Double.toString(i));
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException e){
                    e.printStackTrace();
                }

                windowNum = 1;
            }
        } else {
            g.setColor(Color.CYAN);
        }
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

        if (!executed) {

            File file = new File("src/stats.txt");
            String content = new String();

            try {
                Scanner sc = new Scanner(new FileInputStream(file));
                while (sc.hasNextLine()){
                    content = sc.nextLine();
                    allTimeStats.add(Double.valueOf(content));
                }
                sc.close();

            } catch(FileNotFoundException fnf){
                fnf.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            allTimeStats.set(2, allTimeStats.get(2) + 5);

            if (GeneralMap.lapTimes.getFirst() < allTimeStats.get(0)) {
                allTimeStats.set(0, GeneralMap.lapTimes.getFirst());
            }
            if (cT < allTimeStats.get(1)) {
                allTimeStats.set(1, cT);
            }
        
        executed = true;

        }

        g.fillRect(160, 275, 640, 3);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 78));
        g.drawString("Laps Complete", 245, 240);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        g.drawString("Best Lap: ", 180, 370);
        g.drawString(String.format("%.02f", GeneralMap.lapTimes.getFirst()), 600, 370);
        g.drawString("Best All Time Lap: ", 190, 470);
        g.drawString(String.format("%.02f", allTimeStats.get(0)), 600, 470);
        g.drawString("Completion Time: ", 200, 570);
        g.drawString(String.format("%.02f", cT), 600, 570);
        g.drawString("Best Completion: ", 210, 670);
        g.drawString(String.format("%.02f", allTimeStats.get(1)), 600, 670);
        g.drawString("Totals Laps: ", 220, 770);
        g.drawString(String.valueOf(allTimeStats.get(2)), 600, 770);

        g.drawImage(kart, (int)(1440 - (kart.getWidth()*.75)), (int)(500 - (kart.getHeight()*1.25)), (int)(kart.getWidth()*1.5), (int)(kart.getHeight()*1.5), null);

        g2.setStroke(oldStroke);

    }

}
