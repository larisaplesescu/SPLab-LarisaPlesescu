package ro.uvt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punctul de intrare principal al aplicației Spring Boot.
 * Această clasă pornește contextul Spring, încarcă toate componentele
 * (@Component, @RestController, @Service, @Configuration, etc.)
 * și inițializează serverul Tomcat pe portul 8080.
 */
@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        // Pornește aplicația Spring Boot
        SpringApplication.run(MySpringApplication.class, args);

        System.out.println("\n==========================================");
        System.out.println("  SP_LAB4 - Chain of Responsibility & Command");
        System.out.println("  Aplicatia ruleaza pe: http://localhost:8080/");
        System.out.println("==========================================\n");
    }
}
