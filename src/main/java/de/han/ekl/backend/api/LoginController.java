package de.han.ekl.backend.api;

import de.han.ekl.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    ApplicationContext ctx;
    @GetMapping(path= "/userlogin/{firstname}/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@PathVariable String firstname, @PathVariable String lastname){

        User user = new User();
        user.setLastname(lastname);
        user.setFirstname (firstname);
        user.setIsLogin(true);
        user.setMsg("Hello "+user.getFirstname()+ " " + user.getLastname());
        String path = ctx.getEnvironment().getProperty("Path");
        System.out.println("Name environment implementation : " + ctx.getEnvironment().getClass().getName());
        System.out.println("evn : " + ctx.getEnvironment().getProperty("env"));
        System.out.println("user.home:" + ctx.getEnvironment().getProperty("user.home"));
        System.out.println("java.home:" + ctx.getEnvironment().getProperty("java.home"));
        System.out.println("JAVA_HOME:" + ctx.getEnvironment().getProperty("JAVA_HOME"));
        user.setPath(path);
        System.out.println("Path:" + ctx.getEnvironment().getProperty("Path"));
        System.out.println("PATH:" + ctx.getEnvironment().getProperty("PATH"));
        return ResponseEntity.ok(user);
    }
}
