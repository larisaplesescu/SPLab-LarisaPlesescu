package com.example.sp_lab2;

import java.io.PrintStream;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, PrintStream context) {
        context.println("Align Right: " + paragraph.getText());
    }
}
