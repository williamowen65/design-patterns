package creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        User user = new User.Builder("Will")
                .email("will@example.com")
                .age(42)
                .location("Seattle")
                .emailNotifications(true)
                .build();

        System.out.println(user);
    }
}
