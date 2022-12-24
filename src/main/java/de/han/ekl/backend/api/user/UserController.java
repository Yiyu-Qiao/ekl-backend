package de.han.ekl.backend.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/api/user/{userId}")
    public ResponseEntity<?> getUserDetail(@PathVariable String userId){
        var user = userService.getUserById(userId);
        user.setPasswd(userId);
        return ResponseEntity.ok().body(user);
    }
}
