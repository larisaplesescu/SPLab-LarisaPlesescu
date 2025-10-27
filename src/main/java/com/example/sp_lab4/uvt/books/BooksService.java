package ro.uvt.books;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Book> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Book create(Book book) {
        Long id = idGen.getAndIncrement();
        book.setId(id);
        // pretend we obtained ISBN from external service
        if (book.getIsbn() == null) book.setIsbn("ISBN-" + id);
        store.put(id, book);
        return book;
    }

    public Optional<Book> update(Long id, Book b) {
        if (!store.containsKey(id)) return Optional.empty();
        b.setId(id);
        store.put(id, b);
        return Optional.of(b);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
