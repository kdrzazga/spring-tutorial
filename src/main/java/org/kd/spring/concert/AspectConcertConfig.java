package org.kd.spring.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConcertConfig {

    @Bean
    public Performance createPerformance() {
        return new ClownPerformance();
    }

}
