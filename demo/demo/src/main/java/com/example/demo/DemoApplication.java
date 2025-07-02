package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {14


		//when working with xml based configuration we do this here
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

		Car car= context.getBean("myCar", Car.class);
		car.drive();
	}

}
