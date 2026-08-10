public class TextEditor {
    private String text = "";

    public void type(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    public EditorMemento save() {
        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {
        text = memento.getSavedText();
    }
}
