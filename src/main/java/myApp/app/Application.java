package myApp.app;

import myApp.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "myApp")
@EnableJpaRepositories(basePackages = "myApp")
@EntityScan(basePackages = "myApp")
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    ILocationService locationService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("asdasd");
    }
}
