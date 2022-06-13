package src;

import javax.swing.*;
import java.awt.*;
 
public class Main {
 
    public static void main(String args[]) {
 
        //Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
 
        GamePanel panel = new GamePanel();
        EventListener event = new EventListener(panel.kart);
       
        JFrame frame = new JFrame();
       
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/karts/redkart.png")));
        frame.setBounds(0, 0, 1920, 1000);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TurboKartMania");
        frame.setVisible(true);
 
        frame.addKeyListener(event);
        frame.addMouseListener(panel);

        panel.inGameTime.startTimer();
        frame.add(panel);
    }
 
}
