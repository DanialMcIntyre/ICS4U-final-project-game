import java.awt.event.*;
import javax.swing.Timer;
import java.util.HashSet;
 
public class EventListener extends GamePanel implements KeyListener {
 
    private Kart kart;
 
    HashSet<Integer> pressedKeys = new HashSet<Integer>();
 
    public EventListener(Kart kart) {
        this.kart = kart;
 
        new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(!pressedKeys.isEmpty()){
 
                    //Key Events Go Here
 
                    if (pressedKeys.contains(KeyEvent.VK_W)) {
                        kart.moveForward();
                    }
           
                    if (kart.getAccTime() > 0) {
 
                        if (pressedKeys.contains(KeyEvent.VK_D)) {
                            kart.moveRight();
                        }
               
                        if (pressedKeys.contains(KeyEvent.VK_A)) {
                            kart.moveLeft();
                        }
                    }
                }
            }
        }).start();
 
    }
 
    public void keyPressed(KeyEvent e) {
 
        int keyCode = e.getKeyCode();
        pressedKeys.add(keyCode);
 
    }
 
    public void keyTyped(KeyEvent e) {
 
        int keyCode = e.getKeyCode();
        pressedKeys.remove(keyCode);
 
    }
 
    public void keyReleased(KeyEvent e) {
 
        int keyCode = e.getKeyCode();
        pressedKeys.remove(keyCode);
 
        if (e.getKeyCode() == KeyEvent.VK_W) {
            kart.setIsAccelerating(false);
        }
 
    }
   
}
