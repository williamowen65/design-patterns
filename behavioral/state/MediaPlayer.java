public class MediaPlayer {
    private PlayerState state = new StoppedState();

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }

    public String getStateName() {
        return state.name();
    }
}
