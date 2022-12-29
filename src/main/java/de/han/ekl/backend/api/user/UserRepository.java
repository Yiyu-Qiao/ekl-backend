package de.han.ekl.backend.api.user;

import de.han.ekl.backend.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    public Optional<User> getUserById(String id){
        if(id.equalsIgnoreCase("Test")){
            return Optional.empty();
        }
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setFirstname(id);
        user.setLastname(id);
        user.setBirthday(LocalDate.now());
        return Optional.of(user);
    }
}
