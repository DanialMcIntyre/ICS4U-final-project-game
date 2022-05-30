import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

public class Kart {

    private int xPos;
    private int yPos;
    private double xVelocity;
    private double yVelocity;
    private int angle;

    private final static int width = 75;
    private final static int height = 75;

    private final static int acceleration = 2;
    private double accTime = 0;
    private boolean isAccelerating = false;

    private double frictionLevel = 0.0;

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

    public double getAccTime() {
        return this.accTime;
    }

    public boolean getIsAccelerating() {
        return this.isAccelerating;
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

    public void setAccTime(double t) {
        this.accTime = t;
    }

    public void setIsAccelerating(boolean a) {
        this.isAccelerating = a;
    }

    //Draw function
    public void draw(Graphics g) {

        double rotationRequired = -Math.toRadians(angle);
        double locationX = kart.getWidth() / 2;
        double locationY =  kart.getHeight() / 2;

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        g.drawImage(op.filter(this.kart, null), this.xPos, this.yPos, width, height, null);
    } 

    //Calculates the amount the car moves per frame
    public int moveKartAmount(int acceleration, double accTime) {
        return (int)((acceleration * accTime));
    }

    public void updateKart() {

        //Move car
        this.setXPos(this.xPos + moveKartAmount(acceleration, this.accTime));

        //Keep Inertia
        if (this.isAccelerating == false && this.accTime > 0) {
            this.accTime -= 0.2 + this.frictionLevel;
        }
        if (this.accTime < 0) {
            this.accTime = 0;
        }

        if (this.getXPos() > 1920) {
            this.setXPos(0);
        }

    }    
    
}
