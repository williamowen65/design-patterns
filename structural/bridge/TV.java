public class TV implements Device {
    private boolean enabled;
    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("TV turned on");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("TV turned off");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("TV volume: " + this.volume);
    }
}
