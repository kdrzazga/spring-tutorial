package org.kd;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringTutorialApp {

    @Getter
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SpringTutorialApp.class, args);

        if (context != null) {
            List.of("SERVER STARTED."
                            , "Available requests:"
                            , "http://localhost:8083/hello"
                            , "http://localhost:8083/helloAuth"
                            , "http://localhost:8083/quote"
                            , "http://localhost:8083/logout"
                            , "Available credentials:"
                            , "for helloAuth: l: admin p: admin1"
                            , "for quote: l: admin p: admin1, l: user p: user1, l: mod p: mod1"
                    )
                    .forEach(System.out::println);
        }
    }

}
