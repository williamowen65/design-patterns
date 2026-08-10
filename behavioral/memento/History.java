import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private final Deque<EditorMemento> snapshots = new ArrayDeque<>();

    public void push(EditorMemento memento) {
        snapshots.push(memento);
    }

    public EditorMemento pop() {
        if (snapshots.isEmpty()) {
            throw new IllegalStateException("No earlier state to restore");
        }
        return snapshots.pop();
    }

    public boolean isEmpty() {
        return snapshots.isEmpty();
    }
}
