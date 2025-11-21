package com.example.sp_lab5.uvt.controllers;

import com.example.sp_lab5.uvt.books.Book;
import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.observer.AllBooksSubject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private AllBooksSubject allBooksSubject;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return booksService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        Book saved = booksService.create(newBook);
        allBooksSubject.add(saved);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(booksService.update(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        booksService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
