package com.example.demo;

public class  Car{
    private final Engine engine ;
    
    public Car(Engine engine){
        this.engine= engine;
    }
    
    public  void drive(){
        System.out.println("Driving the class ,....");
        engine.start();
    }
    
}
