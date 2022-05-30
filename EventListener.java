import java.awt.event.*;

public class EventListener extends GamePanel implements KeyListener {

    private Kart kart;

    public EventListener(Kart kart) {
        this.kart = kart;
    }

    public void keyPressed(KeyEvent e) {

        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) {
            kart.moveForward();
        }

        if (k == KeyEvent.VK_D) {
            kart.moveRight();
        }

        if (k == KeyEvent.VK_A) {
            kart.moveLeft();
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            kart.setIsAccelerating(false);
        }

    }
    
}
