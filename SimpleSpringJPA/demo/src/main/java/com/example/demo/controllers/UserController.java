package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public  ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser= userRepository.save(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PostMapping("/mockinput")
    public ResponseEntity<List<User>> mockInputData(@Valid @RequestBody List<User> users){
        List<User>  inputUserlist= userRepository.saveAll(users);
        return  ResponseEntity.status(HttpStatus.CREATED).body(inputUserlist);


    }
    @GetMapping
    public List<User> getAllUser(){
        return  userRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user= userRepository.findById(id);
        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser( @PathVariable Long id , @Valid  @RequestBody User userDetails){
        return  userRepository.findById(id).map(exisistingUser->{
            exisistingUser.setName((userDetails.getName()));
            exisistingUser.setEmail((userDetails.getEmail()));
            User updatedUser= userRepository.save(exisistingUser);
            return  ResponseEntity.ok(updatedUser);
        }).orElse(ResponseEntity.notFound().build());


    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUserById(@PathVariable Long id){
       /* User userFound = userRepository.findById(id);
        if(userFound== null){ return  ResponseEntity.notFound().build();}*/
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return  ResponseEntity.noContent().build();
        }else{
            return  ResponseEntity.notFound().build();

        }

    }



}
