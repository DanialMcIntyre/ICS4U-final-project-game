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

    public int moveKartAmount(int acceleration, double accTime, int angle) {
        return (int)((acceleration * accTime));
    }
}
