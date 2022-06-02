package src;
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
 
                    //Accelerate
                    if (pressedKeys.contains(KeyEvent.VK_W) || pressedKeys.contains(KeyEvent.VK_UP)) {
                        kart.moveForward();
                    }

                    //Deccelerate
                    if (pressedKeys.contains(KeyEvent.VK_S) || pressedKeys.contains(KeyEvent.VK_DOWN)) {
                        kart.moveBackwards();
                    }
           
                    //Right and left
                    if (kart.getAccTime() > 0.1 || kart.getAccTime() < -0.1) {
 
                        if (pressedKeys.contains(KeyEvent.VK_D) || pressedKeys.contains(KeyEvent.VK_RIGHT)) {
                            kart.moveRight();
                        }
               
                        if (pressedKeys.contains(KeyEvent.VK_A) || pressedKeys.contains(KeyEvent.VK_LEFT)) {
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
 
        //Stop accelerating
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            kart.setIsAccelerating(false);
        }

        //Stop deccelerating
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            kart.setIsDeccelerating(false);
        }
 
    }
   
}
