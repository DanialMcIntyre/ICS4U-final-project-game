package src.events;

import java.awt.event.*;

import src.GamePanel;

public class MouseEventHandler extends GamePanel implements MouseListener, MouseMotionListener {

    private GamePanel panel; 

    public MouseEventHandler(GamePanel panel) {
        this.panel = panel;
    }
    
    public void mouseClicked(MouseEvent e) {
        panel.mouseClicked = true;
    }

    public void mousePressed(MouseEvent arg0) { }

    public void mouseEntered(MouseEvent arg0) { }

    public void mouseReleased(MouseEvent arg0) { }

    public void mouseExited(MouseEvent arg0) { }

    public void mouseMoved(MouseEvent e) {
        panel.p = e.getPoint();
    }

    public void mouseDragged(MouseEvent arg0) { }

}
