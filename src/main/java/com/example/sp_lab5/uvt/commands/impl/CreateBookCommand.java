package com.example.sp_lab5.uvt.commands.impl;

import com.example.sp_lab5.uvt.books.Book;
import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.commands.Command;

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
