package ro.uvt.commands.impl;

import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;

public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService booksService;
    private final Long id;
    public DeleteBookCommand(BooksService s, Long id){ this.booksService=s; this.id=id; }
    @Override
    public Boolean execute(){ return booksService.delete(id); }
}
