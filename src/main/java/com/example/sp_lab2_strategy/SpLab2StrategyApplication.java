package com.example.sp_lab2_strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLab2StrategyApplication {

    public static void main(String[] args) {
        Context context = new Context();

        // folosim diferite strategii
        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy();

        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy();

        context.setStrategy(new ConcreteStrategyC());
        context.executeStrategy();

        // folosim noua strategie AlignStrategy
        context.setStrategy(new AlignStrategy());
        context.executeStrategy();
    }
}
