package com.example.sp_lab2_strategy;

class ConcreteStrategyC implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy C: Random order processing...");
    }
}
