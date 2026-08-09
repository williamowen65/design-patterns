import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name + "/");

        for (FileSystemItem child : children) {
            child.display(indent + "  ");
        }
    }
}
