import java.lang.Math;
 
public class Physics {
   
    public double inertia(boolean isAcc, boolean isDecc, double accT, double fric) {
        if (!(isAcc) && accT > 0) {
            accT -= 0.2 + fric;
        }

        if (!(isDecc) && accT < 0) {
            accT += 0.2 + fric;
        }

        return accT;
    }
 
    public int moveKartAmountX(int acceleration, double accTime, int angle) {
        return (int)Math.round((acceleration * accTime)* Math.cos(Math.toRadians(angle)));
    }
 
    public int moveKartAmountY(int acceleration, double accTime, int angle) {
        return (int)Math.round((acceleration * accTime)* Math.sin(Math.toRadians(angle)));
    }
}
