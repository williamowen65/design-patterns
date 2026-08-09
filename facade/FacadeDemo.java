package facade;

public class FacadeDemo {
    public static void main(String[] args) {
        Television television = new Television();
        SoundSystem soundSystem = new SoundSystem();
        StreamingPlayer streamingPlayer = new StreamingPlayer();

        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(television, soundSystem, streamingPlayer);

        homeTheater.watchMovie("The Design Pattern Adventure");
        System.out.println();
        homeTheater.endMovie();
    }
}
