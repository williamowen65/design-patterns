package facade;

public class FacadeDemo {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Television(), new SoundSystem(), new StreamingPlayer());
        homeTheater.watchMovie("The Design Pattern Adventure");
        homeTheater.endMovie();
    }
}
