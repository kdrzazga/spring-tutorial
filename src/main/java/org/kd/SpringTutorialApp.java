package org.kd;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)//exclusion necesssary for JMS
public class SpringTutorialApp {

    @Getter
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SpringTutorialApp.class, args);

        if (context != null) {
            List.of("SERVER STARTED."
                            , "Available requests:"
                            , "No authentication required:"
                            , "http://localhost:8080/countries"
                            , "http://localhost:8080/country/0"
                            , "http://localhost:8083/hello"
                            , "http://localhost:8083/helloAuth"
                            , "http://localhost:8083/quote"
                            , "\nWith authentication:"
                            , "http://localhost:8080/place/1,1"
                            , "http://localhost:8080/response-entity-builder-with-http-headers"
                            , "http://localhost:8083/logout"
                            , "Available credentials:"
                            , "l: playero p: pass"
                            , "l: playerx p: pass"
                    )
                    .forEach(System.out::println);
        }
    }

}
