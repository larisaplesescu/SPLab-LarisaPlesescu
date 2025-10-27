package ro.uvt.executors;

import ro.uvt.commands.Command;

import java.util.concurrent.Future;

public interface CommandExecutor {
    <T> T execute(Command<T> cmd) throws Exception;
}
