public class VideoProxy implements Video {
    private final String filename;
    private RealVideo realVideo;

    public VideoProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(filename);
        }

        realVideo.play();
    }
}
