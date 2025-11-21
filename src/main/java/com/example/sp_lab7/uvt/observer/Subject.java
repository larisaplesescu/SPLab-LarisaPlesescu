package com.example.sp_lab5.uvt.observer;

import com.example.sp_lab5.uvt.books.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(Book book);
}