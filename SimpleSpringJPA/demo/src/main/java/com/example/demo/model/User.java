package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.xml.transform.sax.SAXResult;
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 60 , message = "Name length must be under the range 2,10")
    private  String  name;
    @Email(message = "Email should be valid ")
    @NotBlank(message = "email  is required")
    private  String  email;

    public void setEmail(String email) {
        this.email = email;
    }
     public  User(){

     }


    public  User( String  name , String  email){
        this.email= email;
        this.name= name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String  getEmail() {
        return email;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String  getName() {
        return name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                '}';
    }



}
