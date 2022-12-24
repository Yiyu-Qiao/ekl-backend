package de.han.ekl.backend.api.authentication;

import de.han.ekl.backend.api.user.UserService;
import de.han.ekl.backend.model.LoginRequest;
import de.han.ekl.backend.model.User;
import de.han.ekl.backend.util.EklUtilities;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext ctx;

    @PostMapping(path= "/api/auth/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@RequestBody @Valid LoginRequest loginRequest){
        EklUtilities.printEnvironment(ctx);
        User user = userService.getUserById("username");
        user.setLastname(loginRequest.getUsername());
        user.setPasswd(loginRequest.getPwd());
        return ResponseEntity.ok(user);
    }
}
