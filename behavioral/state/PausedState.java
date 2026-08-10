public class PausedState implements PlayerState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming playback");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Player is already paused");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Stopping playback");
        player.setState(new StoppedState());
    }

    @Override
    public String name() {
        return "Paused";
    }
}
