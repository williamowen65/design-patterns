import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookCollection implements Iterable<Book> {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookIterator(books);
    }
}
