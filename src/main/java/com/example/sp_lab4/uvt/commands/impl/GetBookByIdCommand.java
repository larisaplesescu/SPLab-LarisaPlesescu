package ro.uvt.commands.impl;

import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;
import ro.uvt.books.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long id;
    public GetBookByIdCommand(BooksService s, Long id){ this.booksService=s; this.id=id; }
    @Override
    public Optional<Book> execute(){ return booksService.findById(id); }
}
