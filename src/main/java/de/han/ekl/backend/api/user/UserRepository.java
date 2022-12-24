package de.han.ekl.backend.api.user;

import de.han.ekl.backend.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public class UserRepository {

    public User getUserById(String id){
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setFirstname("Qiao");
        user.setLastname("Han");
        user.setBirthday(LocalDate.now());
        return user;
    }
}
