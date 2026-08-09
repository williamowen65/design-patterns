public class RealVideo implements Video {
    private final String filename;

    public RealVideo(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Expensive load from disk: " + filename);
    }

    @Override
    public void play() {
        System.out.println("Playing: " + filename);
    }
}
