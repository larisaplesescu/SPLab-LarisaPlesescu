package com.example.sp_lab2_strategy;

class AlignStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing AlignStrategy: Aligning text to center...");
    }
}