package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.uvt.books.BooksService;
import ro.uvt.commands.Command;
import ro.uvt.commands.impl.*;
import ro.uvt.executors.AsyncCommandExecutor;
import ro.uvt.executors.CommandExecutor;
import ro.uvt.books.Book;
import ro.uvt.executors.AsyncTaskStore;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor syncExecutor;
    private final AsyncCommandExecutor asyncExecutor;
    private final AsyncTaskStore taskStore;

    @Autowired
    public BooksController(BooksService booksService,
                           CommandExecutor syncExecutor, // syncExecutor bean named "syncExecutor"
                           AsyncCommandExecutor asyncExecutor,
                           AsyncTaskStore taskStore){
        this.booksService = booksService;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.taskStore = taskStore;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        try {
            Command<List<Book>> cmd = new GetAllBooksCommand(booksService);
            List<Book> res = syncExecutor.execute(cmd);
            return ResponseEntity.ok(res);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        try {
            Command<Optional<Book>> cmd = new GetBookByIdCommand(booksService, id);
            Optional<Book> res = syncExecutor.execute(cmd);
            return res.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // CREATE -> chosen as ASYNCHRONOUS (returns 202 + task-id)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book payload){
        // create command
        CreateBookCommand cmd = new CreateBookCommand(booksService, payload);
        // submit async
        String taskId = asyncExecutor.submitAsync(cmd);
        // return 202 with location to check status
        return ResponseEntity.accepted()
                .header("Location", "/tasks/" + taskId)
                .body("Accepted taskId=" + taskId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book payload){
        try {
            UpdateBookCommand cmd = new UpdateBookCommand(booksService, id, payload);
            Optional<Book> res = syncExecutor.execute(cmd);
            return res.map(b -> ResponseEntity.ok(b))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            DeleteBookCommand cmd = new DeleteBookCommand(booksService, id);
            Boolean deleted = syncExecutor.execute(cmd);
            if (deleted) return ResponseEntity.noContent().build();
            else return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
