package com.example.sp_lab2;

import java.io.PrintStream;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream context) {
        context.println("Align Center: " + paragraph.getText());
    }
}
