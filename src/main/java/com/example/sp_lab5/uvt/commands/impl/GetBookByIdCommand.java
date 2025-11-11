package com.example.sp_lab5.uvt.commands.impl;

import com.example.sp_lab5.uvt.books.Book;
import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.commands.Command;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long id;
    public GetBookByIdCommand(BooksService s, Long id){ this.booksService=s; this.id=id; }
    @Override
    public Optional<Book> execute(){ return booksService.findById(id); }
}
