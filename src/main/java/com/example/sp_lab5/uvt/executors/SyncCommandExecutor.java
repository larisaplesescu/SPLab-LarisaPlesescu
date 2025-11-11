package com.example.sp_lab5.uvt.executors;

import com.example.sp_lab5.uvt.commands.Command;
import org.springframework.stereotype.Component;

@Component("syncExecutor")
public class SyncCommandExecutor implements CommandExecutor {
    @Override
    public <T> T execute(Command<T> cmd) throws Exception {
        return cmd.execute();
    }
}
