package ro.uvt.commands.impl;

import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;
import ro.uvt.books.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long id;
    private final Book payload;
    public UpdateBookCommand(BooksService s, Long id, Book p){ this.booksService=s; this.id=id; this.payload=p; }
    @Override
    public Optional<Book> execute(){ return booksService.update(id, payload); }
}
