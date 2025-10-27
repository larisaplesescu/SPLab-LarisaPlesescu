

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ro.uvt.difexamples.ClientComponent;
import ro.uvt.difexamples.SingletonComponent;
import ro.uvt.difexamples.TransientComponent;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MySpringApplication.class, args);

        System.out.println("\n--- Transient Beans ---");
        TransientComponent t1 = context.getBean(TransientComponent.class);
        t1.operation();
        TransientComponent t2 = context.getBean(TransientComponent.class);
        t2.operation();

        System.out.println("\n--- Singleton Beans ---");
        SingletonComponent s1 = context.getBean(SingletonComponent.class);
        s1.operation();
        SingletonComponent s2 = context.getBean(SingletonComponent.class);
        s2.operation();

        System.out.println("\n--- Client Component ---");
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
    }
}