package src.obstacles;

import java.awt.*;

public class Obstacle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    private boolean tangible;

    public Obstacle(int x, int y, int w, int h, Color c, boolean t) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
        this.tangible = t;
    }

    public int getXPos() {
        return this.x;
    }

    public int getYPos() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isTangible() {
        return this.tangible;
    }

    public void setXPos(int x) {
        this.x = x;
    }

    public void setYPos(int y) {
        this.y = y;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setIsTangible(boolean t) {
        this.tangible = t;
    }
    
}
