package com.example.DBRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users") // READ operation in CRUD
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}") // READ operation in CRUD
    public Optional<User> getAllUserById(@PathVariable(value="userId") String userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/user") // CREATE operation in CRUD
    public @Valid User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{userId}") // UPDATE operation for CRUD
    public @Valid User updateUser(@PathVariable(value="UserId") String UserId, @Valid @RequestBody User user)
            throws UserNotFoundException {
        User acc = userRepository.findById(UserId).orElseThrow(()->new UserNotFoundException(UserId));
        acc.setUserName(user.getUserName());
        User upduser = userRepository.save(acc);
        return upduser;
    }

    @DeleteMapping("Users/{UserId}") // DELETE operation for CRUD
    public ResponseEntity<Void> deleteUser(@PathVariable("UserId") String UserId) throws UserNotFoundException {
        User acc = userRepository.findById(UserId).orElseThrow(()->new UserNotFoundException(UserId));
        userRepository.deleteById(UserId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
