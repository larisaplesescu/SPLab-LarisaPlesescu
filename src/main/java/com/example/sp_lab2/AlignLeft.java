package com.example.sp_lab2;

import java.io.PrintStream;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream context) {
        context.println("Align Left: " + paragraph.getText());
    }
}
