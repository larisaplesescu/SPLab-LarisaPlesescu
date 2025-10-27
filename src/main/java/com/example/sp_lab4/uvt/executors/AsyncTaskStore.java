package ro.uvt.executors;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class AsyncTaskStore {
    private final Map<String, Future<?>> tasks = new ConcurrentHashMap<>();
    private final Map<String, Object> results = new ConcurrentHashMap<>();

    public void put(String id, Future<?> f){
        tasks.put(id, f);
    }
    public Future<?> getFuture(String id){ return tasks.get(id); }
    public void putResult(String id, Object res){ results.put(id, res); }
    public Object getResult(String id){ return results.get(id); }
    public boolean isDone(String id){
        Future<?> f = tasks.get(id);
        return f != null && f.isDone();
    }
}
