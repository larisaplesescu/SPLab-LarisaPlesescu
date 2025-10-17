package com.example.sp_lab2_strategy;

class Context {
    private Strategy strategy;

    // setarea strategiei la runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // metoda care folosește strategia curentă
    public void executeStrategy() {
        if (strategy != null) {
            strategy.execute();
        } else {
            System.out.println("No strategy selected!");
        }
    }
}