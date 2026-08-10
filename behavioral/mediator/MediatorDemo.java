public class MediatorDemo {
    public static void main(String[] args) {
        ChatMediator room = new ChatRoom();

        User will = new ConcreteUser(room, "Will");
        User maya = new ConcreteUser(room, "Maya");
        User leo = new ConcreteUser(room, "Leo");

        room.addUser(will);
        room.addUser(maya);
        room.addUser(leo);

        will.send("Anyone want to review this PR?");
        maya.send("Sure, send it over.");
    }
}
