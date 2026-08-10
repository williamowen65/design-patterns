public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.type("Hello");
        history.push(editor.save());

        editor.type(", world");
        history.push(editor.save());

        editor.type("!!!");
        System.out.println("Current: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Undo 1:  " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Undo 2:  " + editor.getText());
    }
}
