public class StateDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        System.out.println("Initial: " + player.getStateName());
        player.play();
        System.out.println("Now: " + player.getStateName());

        player.pause();
        System.out.println("Now: " + player.getStateName());

        player.play();
        System.out.println("Now: " + player.getStateName());

        player.stop();
        System.out.println("Now: " + player.getStateName());
    }
}
