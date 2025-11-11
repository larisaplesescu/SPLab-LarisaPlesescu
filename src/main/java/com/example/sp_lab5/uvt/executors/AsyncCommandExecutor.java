package com.example.sp_lab5.uvt.executors;

import com.example.sp_lab5.uvt.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Component("asyncExecutor")
public class AsyncCommandExecutor implements CommandExecutor {

    private final ExecutorService executor;
    private final AsyncTaskStore store;

    @Autowired
    public AsyncCommandExecutor(ExecutorService executor, AsyncTaskStore store){
        this.executor = executor;
        this.store = store;
    }

    // NOTE: for async we will not return the actual result immediately.
    // to keep CommandExecutor contract, we throw if used directly.
    @Override
    public <T> T execute(Command<T> cmd) throws Exception {
        throw new UnsupportedOperationException("Use submitAsync for async execution");
    }

    public String submitAsync(Command<?> cmd){
        String id = UUID.randomUUID().toString();
        Future<?> f = executor.submit(() -> {
            try {
                Object res = cmd.execute();
                store.putResult(id, res);
                return res;
            } catch (Exception e) {
                store.putResult(id, e);
                throw new RuntimeException(e);
            }
        });
        store.put(id, f);
        return id;
    }
}
