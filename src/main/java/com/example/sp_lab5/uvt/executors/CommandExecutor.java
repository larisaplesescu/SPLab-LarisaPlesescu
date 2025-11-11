package com.example.sp_lab5.uvt.executors;

import com.example.sp_lab5.uvt.commands.Command;

public interface CommandExecutor {
    <T> T execute(Command<T> cmd) throws Exception;
}
