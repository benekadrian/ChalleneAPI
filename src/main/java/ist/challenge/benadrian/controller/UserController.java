package ist.challenge.benadrian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ist.challenge.benadrian.model.UserModel;
import ist.challenge.benadrian.service.UserService;

@RestController
@RequestMapping(path = "/api/test1/")
public class UserController {

    @Autowired
    UserService userService;

    
    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody UserModel user) {
        return userService.save(user);
    }

    
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserModel user) {
        return userService.login(user);
    }

    //list user
    @GetMapping
    public ResponseEntity<Object> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserModel user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
