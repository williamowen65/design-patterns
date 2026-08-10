public class IteratorDemo {
    public static void main(String[] args) {
        BookCollection shelf = new BookCollection();
        shelf.addBook(new Book("Clean Code"));
        shelf.addBook(new Book("Design Patterns"));
        shelf.addBook(new Book("The Pragmatic Programmer"));

        for (Book book : shelf) {
            System.out.println(book.getTitle());
        }
    }
}
