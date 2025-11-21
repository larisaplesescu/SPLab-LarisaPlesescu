package com.example.sp_lab5.uvt.commands.impl;

import com.example.sp_lab5.uvt.books.Book;
import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.commands.Command;

import java.util.Optional;

public class UpdateBookCommand implements Command {
    private Long id;
    private Book payload;
    private BooksService booksService;

    public Optional<Book> execute() {
        return Optional.ofNullable(booksService.update(id, payload));
    }
}

