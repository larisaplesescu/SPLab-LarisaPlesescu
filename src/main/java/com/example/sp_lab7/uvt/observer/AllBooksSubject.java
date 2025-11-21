package com.example.sp_lab5.uvt.observer;

import com.example.sp_lab5.uvt.books.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}
