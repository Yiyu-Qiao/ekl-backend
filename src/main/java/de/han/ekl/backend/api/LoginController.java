package de.han.ekl.backend.api;

import de.han.ekl.backend.model.User;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping(path= "/userlogin/{firstname}/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@PathVariable String firstname, @PathVariable String lastname){
        User user = new User();
        user.setLastname(lastname);
        user.setFirstname (firstname);
        user.setIsLogin(true);
        user.setMsg("Hello "+user.getFirstname()+ " " + user.getLastname());
        return ResponseEntity.ok(user);
    }
}
