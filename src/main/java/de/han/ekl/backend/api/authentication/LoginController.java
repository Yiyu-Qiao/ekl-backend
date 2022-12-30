package de.han.ekl.backend.api.authentication;

import de.han.ekl.backend.api.user.UserService;
import de.han.ekl.backend.exception.UserNotFoundException;
import de.han.ekl.backend.exception.UsernameOrPasswordInvalidException;
import de.han.ekl.backend.model.User;
import de.han.ekl.backend.token.JWTProvider;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class LoginController {

   @Autowired
   private UserService userService;

    private JWTProvider jwtProvider = new JWTProvider();

    private ApplicationContext ctx;

    @PostMapping(path= "/api/auth/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@RequestBody @Valid LoginRequest loginRequest) throws UsernameOrPasswordInvalidException {
//        EklUtilities.printEnvironment(ctx);
        try{
            User user = userService.getUserById(loginRequest.getUsername());            ;
            user.setToken(jwtProvider.createJWT(user));
            return ResponseEntity.ok(user);
        }catch(UserNotFoundException e){
            throw new UsernameOrPasswordInvalidException(e.getMessage());
        }
    }
}
