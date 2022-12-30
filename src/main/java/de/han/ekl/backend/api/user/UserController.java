package de.han.ekl.backend.api.user;

import de.han.ekl.backend.exception.UserNotFoundException;
import de.han.ekl.backend.token.JWTValidator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private JWTValidator jwtValidator = new JWTValidator();

    @GetMapping(path = "/api/user/{userId}")
    @PreAuthorize("hasRole(USER)")
    public ResponseEntity<?> getUserDetail(@PathVariable String userId) throws UserNotFoundException {
        var user = userService.getUserById(userId);
        user.setPasswd(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/test/user")
    public ResponseEntity<?> getTestUserDetail(@RequestHeader("Authorization") String jwt) {
        var isValid = jwtValidator.validateJWT(jwt);
        if(isValid){
            Claims claims = jwtValidator.readJWT(jwt);
            return ResponseEntity.ok().body(claims);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
