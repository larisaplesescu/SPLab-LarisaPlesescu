package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.uvt.executors.AsyncTaskStore;

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
