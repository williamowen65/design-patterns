public class EditorMemento {
    private final String savedText;

    public EditorMemento(String savedText) {
        this.savedText = savedText;
    }

    public String getSavedText() {
        return savedText;
    }
}
