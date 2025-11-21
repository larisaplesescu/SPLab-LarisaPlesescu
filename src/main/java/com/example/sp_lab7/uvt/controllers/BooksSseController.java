package com.example.sp_lab5.uvt.controllers;

import com.example.sp_lab5.uvt.observer.AllBooksSubject;
import com.example.sp_lab5.uvt.observer.SseObserver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter streamBooks() {
        SseEmitter emitter = new SseEmitter(0L);
        allBooksSubject.attach(new SseObserver(emitter));
        return emitter;
    }
}
