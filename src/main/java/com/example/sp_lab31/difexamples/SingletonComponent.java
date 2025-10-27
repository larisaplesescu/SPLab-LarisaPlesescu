package com.example.sp_lab31.difexamples;

import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {

    public SingletonComponent() {
        System.out.println("SingletonComponent::Constructor = " + this);
    }

    public void operation() {
        System.out.println("Invoked SingletonComponent::operation() on " + this);
    }
}