package tadzhibaeva.spring_security_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "tadzhibaeva")
public class SpringSecurityDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDbApplication.class, args);
    }

}
