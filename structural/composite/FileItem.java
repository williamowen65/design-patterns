public class FileItem implements FileSystemItem {
    private final String name;

    public FileItem(String name) { this.name = name; }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name);
    }
}
