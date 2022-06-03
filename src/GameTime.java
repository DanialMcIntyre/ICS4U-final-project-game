package src;

public class GameTime {
    private long startTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public float getCurrentTime() {
        return (System.currentTimeMillis() - startTime) / 1000f;
    }
}
