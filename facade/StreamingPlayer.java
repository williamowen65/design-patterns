package facade;

public class StreamingPlayer {
    public void on() {
        System.out.println("Streaming player on");
    }

    public void play(String movie) {
        System.out.println("Playing: " + movie);
    }

    public void stop() {
        System.out.println("Streaming stopped");
    }

    public void off() {
        System.out.println("Streaming player off");
    }
}
