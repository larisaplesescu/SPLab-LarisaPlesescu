package com.example.sp_lab5.uvt.books;


import com.example.sp_lab5.uvt.persistence.BooksRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return booksRepository.findById(id);
    }

    public Book create(Book book) {
        return booksRepository.save(book);
    }

    public Book update(Long id, Book book) {
        if (!booksRepository.existsById(id))
            throw new RuntimeException("Book not found!");
        book.setId(id);
        return booksRepository.save(book);
    }

    public Boolean delete(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
