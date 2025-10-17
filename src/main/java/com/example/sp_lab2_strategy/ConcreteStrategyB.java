package com.example.sp_lab2_strategy;

class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B: Sorting data descending...");
    }
}