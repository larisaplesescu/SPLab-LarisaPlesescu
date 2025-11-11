package com.example.sp_lab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLab5Application {

    public static void main(String[] args) {
        // Pornește aplicația Spring Boot
        SpringApplication.run(SpLab5Application.class, args);

        System.out.println("\n==========================================");
        System.out.println("  SP_LAB4 - Chain of Responsibility & Command");
        System.out.println("  Aplicatia ruleaza pe: http://localhost:8080/");
        System.out.println("==========================================\n");
    }
}
