package facade;

public class HomeTheaterFacade {
    private final Television television;
    private final SoundSystem soundSystem;
    private final StreamingPlayer streamingPlayer;

    public HomeTheaterFacade(
            Television television,
            SoundSystem soundSystem,
            StreamingPlayer streamingPlayer) {
        this.television = television;
        this.soundSystem = soundSystem;
        this.streamingPlayer = streamingPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Getting the home theater ready...");
        television.on();
        television.setInput("Streaming Player");
        soundSystem.on();
        soundSystem.setVolume(6);
        streamingPlayer.on();
        streamingPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting the home theater down...");
        streamingPlayer.stop();
        streamingPlayer.off();
        soundSystem.off();
        television.off();
    }
}
