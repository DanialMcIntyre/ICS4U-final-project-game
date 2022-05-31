import java.lang.Math;
 
public class Physics {
   
    public double inertia(boolean isAcc, double accT, double fric) {
        if (!(isAcc) && accT > 0) {
            accT -= 0.2 + fric;
        }
       
        if (accT < 0) {
            accT = 0;
        }
        return accT;
    }
 
    public int moveKartAmountX(int acceleration, double accTime, int angle) {
        return (int)((acceleration * accTime)* Math.cos(Math.toRadians(angle)));
    }
 
    public int moveKartAmountY(int acceleration, double accTime, int angle) {
        return (int)((acceleration * accTime)* Math.sin(Math.toRadians(angle)));
    }
}
