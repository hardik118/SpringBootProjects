package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.transform.sax.SAXResult;
import java.time.LocalDateTime;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 60 , message = "Name length must be under the range 2,10")
    private  String  name;
    @Email(message = "Email should be valid ")
    @NotBlank(message = "email  is required")
    private  String  email;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public void setEmail(String email) {
        this.email = email;
    }
     public  User(){

     }

    public  User(long id, String  name , String  email){
        this.email= email;
        this.id=id;
        this.name= name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String  getEmail() {
        return email;
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
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
