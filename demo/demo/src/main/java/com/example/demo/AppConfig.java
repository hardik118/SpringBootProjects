
package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="myEngine")
    public  Engine engine(){
        return  new Engine();
    }

    @Bean(name = "myCar")
    public  Car car (Engine engine){
        return new Car(engine);

    }
}
