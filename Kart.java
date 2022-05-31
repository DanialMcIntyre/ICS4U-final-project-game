import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
 
public class Kart extends Physics{
 
    private int xPos;
    private int yPos;
    private double xVelocity;
    private double yVelocity;
    private int angle;
 
    private final static int width = 75;
    private final static int height = 75;
 
    private final static int acceleration = 1;
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
 
    public int getAcceleration() {
        return acceleration;
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
        double radian = -Math.toRadians(angle);
        int width = kart.getWidth();
        int height = kart.getHeight();

        BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = rotatedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        
        // rotation around the center point
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(kart, 0, 0, width, height, null);
        graphics.dispose();

        g.drawImage(rotatedImage, this.xPos, this.yPos, this.getWidth(), this.getHeight(), null);
    }
 
    //W key pressed
    public void moveForward() {
        setIsAccelerating(true);
        if (getAccTime() < 10) {
            setAccTime(getAccTime() + 0.1);  
        }
        if (getAccTime() > 10) {
            setAccTime(10);
        }
    }
 
    //D key pressed
    public void moveRight() {
        setAngle(getAngle() - 3);
        if (getAngle() <= -1) {
            setAngle(359);
        }        
    }
 
    //A key pressed
    public void moveLeft() {
        setAngle(getAngle() + 3);
        if (getAngle() >= 360) {
            setAngle(0);
        }        
    }
 
    public void updateKart() {
 
        //Move car
        this.setXPos(this.xPos + moveKartAmountX(acceleration, this.accTime, this.angle));
        this.setYPos(this.yPos - moveKartAmountY(acceleration, this.accTime, this.angle));
 
        //Keep Inertia
        this.accTime = inertia(this.isAccelerating, this.accTime, this.frictionLevel);
 
        if (this.getXPos() > 1920) {
            this.setXPos(0);
        }
 
    }    
   
}
