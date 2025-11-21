package com.example.sp_lab5.uvt.commands.impl;

import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.commands.Command;

public class DeleteBookCommand implements Command<Void> {
    private final BooksService booksService;
    private final Long id;

    public DeleteBookCommand(BooksService s, Long id) {
        this.booksService = s;
        this.id = id;
    }

    @Override
    public Void execute() {
        booksService.delete(id);
        return null;
    }
}
