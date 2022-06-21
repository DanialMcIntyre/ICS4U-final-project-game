package src;

import javax.swing.*;

import src.events.MouseEventHandler;


import src.events.EventListener;

import java.awt.*;
 
public class Main {
 
    public static void main(String args[]) {
 
        GamePanel panel = new GamePanel();
        EventListener event = new EventListener(panel.kart);
        MouseEventHandler mL = new MouseEventHandler(panel);
       
        JFrame frame = new JFrame();
       
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/karts/redkart.png")));
        frame.setBounds(0, 0, 1920, 1000);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TurboKartMania");
        frame.setVisible(true);
 
        frame.addKeyListener(event);
        panel.addMouseListener(mL);
        panel.addMouseMotionListener(mL);

        frame.add(panel);
    }
 
}
