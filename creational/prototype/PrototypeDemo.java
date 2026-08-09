public class PrototypeDemo {
    public static void main(String[] args) {
        Document original = new Document(
                "Project Proposal",
                "This is the standard proposal template."
        );

        Document copy = original.copy();
        copy.setTitle("Client A Proposal");
        copy.setBody("Customized proposal for Client A.");

        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);
    }
}
