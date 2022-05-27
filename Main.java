import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String args[]) {

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        GamePanel panel = new GamePanel();
        
        JFrame frame = new JFrame();
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("images/misc/icon.jpg")));
        frame.setBounds(0, 0, (int)size.getWidth(), (int)size.getHeight());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("TurboKartMania");
        frame.setVisible(true);

        frame.add(panel);
        frame.addKeyListener(panel);
    }

}