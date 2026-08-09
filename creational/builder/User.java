package creational.builder;

public class User {
    private final String name;
    private final String email;
    private final Integer age;
    private final String location;
    private final boolean emailNotifications;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.location = builder.location;
        this.emailNotifications = builder.emailNotifications;
    }

    public static class Builder {
        private final String name;
        private String email;
        private Integer age;
        private String location;
        private boolean emailNotifications;

        public Builder(String name) {
            this.name = name;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder emailNotifications(boolean enabled) {
            this.emailNotifications = enabled;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", emailNotifications=" + emailNotifications +
                '}';
    }
}
