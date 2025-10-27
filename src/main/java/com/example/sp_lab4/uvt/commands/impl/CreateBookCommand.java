package ro.uvt.commands.impl;

import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;
import ro.uvt.books.Book;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book payload;

    public CreateBookCommand(BooksService booksService, Book payload) {
        this.booksService = booksService;
        this.payload = payload;
    }

    @Override
    public Book execute() {
        // aici ar putea fi logică de orchestrare (apel extern pentru ISBN)
        return booksService.create(payload);
    }
}
