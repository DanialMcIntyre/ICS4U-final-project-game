import java.awt.*;
import java.awt.image.BufferedImage;

public class Kart {

    private int xPos;
    private int yPos;
    private double xVelocity;
    private double yVelocity;
    private int angle;

    private final static int width = 150;
    private final static int height = 75;

    private BufferedImage kart;

    public Kart(int x, int y, double xVel, double yVel, int ang, BufferedImage img) {

        this.xPos = x;
        this.yPos = y;
        this.xVelocity = xVel;
        this.yVelocity = yVel;
        this.angle = ang;
        this.kart = img;

    }

    //Getters

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public double getXVelocity() {
        return this.xVelocity;
    }

    public double getYVelocity() {
        return this.yVelocity;
    }

    public int getAngle() {
        return this.angle;
    }

    public BufferedImage getImage() {
        return this.kart;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //Setters

    public void setXPos(int x) {
        this.xPos = x;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public void setXVelocity(double x) {
        this.xVelocity = x;
    }

    public void setYVelocity(double y) {
        this.yVelocity = y;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    //Draw function

    public void draw(Graphics g) {
        g.drawImage(this.kart, this.xPos, this.yPos, width, height, null);
    } 
    
    
}
