public class StoppedState implements PlayerState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Starting playback");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Nothing to pause; player is stopped");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Player is already stopped");
    }

    @Override
    public String name() {
        return "Stopped";
    }
}
