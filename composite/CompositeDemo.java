public class CompositeDemo {
    public static void main(String[] args) {
        FileSystemItem notes = new FileItem("notes.txt");
        FileSystemItem resume = new FileItem("resume.pdf");
        FileSystemItem vacationPhoto = new FileItem("vacation.jpg");

        Folder photos = new Folder("Photos");
        photos.add(vacationPhoto);

        Folder documents = new Folder("Documents");
        documents.add(notes);
        documents.add(resume);
        documents.add(photos);

        System.out.println("A single item:");
        notes.display("");

        System.out.println("\nA whole tree through the same interface:");
        documents.display("");
    }
}
