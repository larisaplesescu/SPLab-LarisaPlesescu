package ro.uvt.commands.impl;

import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;
import ro.uvt.books.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;
    public GetAllBooksCommand(BooksService s){ this.booksService=s; }
    @Override
    public List<Book> execute(){ return booksService.findAll(); }
}
