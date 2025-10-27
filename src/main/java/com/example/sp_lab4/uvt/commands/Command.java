package ro.uvt.commands;

public interface Command<T> {
    T execute() throws Exception;
}
