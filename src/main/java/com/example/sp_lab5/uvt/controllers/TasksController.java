package com.example.sp_lab5.uvt.controllers;

import com.example.sp_lab5.uvt.executors.AsyncTaskStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final AsyncTaskStore store;

    @Autowired
    public TasksController(AsyncTaskStore store){ this.store = store; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable String id){
        Future<?> f = store.getFuture(id);
        if (f == null) return ResponseEntity.notFound().build();
        if (!f.isDone()) return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Task " + id + " is processing");
        Object res = store.getResult(id);
        if (res instanceof Throwable) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Task failed: " + ((Throwable)res).getMessage());
        }
        return ResponseEntity.ok(res);
    }
}
