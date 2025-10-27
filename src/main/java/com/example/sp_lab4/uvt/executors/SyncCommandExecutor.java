package ro.uvt.executors;

import org.springframework.stereotype.Component;
import ro.uvt.commands.Command;

@Component("syncExecutor")
public class SyncCommandExecutor implements CommandExecutor {
    @Override
    public <T> T execute(Command<T> cmd) throws Exception {
        return cmd.execute();
    }
}
