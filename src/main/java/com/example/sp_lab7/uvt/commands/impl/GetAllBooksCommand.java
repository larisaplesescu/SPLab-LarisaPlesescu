package com.example.sp_lab5.uvt.commands.impl;

import com.example.sp_lab5.uvt.books.Book;
import com.example.sp_lab5.uvt.books.BooksService;
import com.example.sp_lab5.uvt.commands.Command;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;
    public GetAllBooksCommand(BooksService s){ this.booksService=s; }
    @Override
    public List<Book> execute(){ return booksService.findAll(); }
}
