public class ProxyDemo {
    public static void main(String[] args) {
        Video video = new VideoProxy("design-patterns.mp4");

        System.out.println("Proxy created. The real video has not been loaded yet.");
        System.out.println();

        video.play();

        System.out.println();
        System.out.println("Playing again. The existing RealVideo is reused.");
        video.play();
    }
}
