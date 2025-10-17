package com.example.sp_lab2_strategy;

class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A: Sorting data ascending...");
    }
}