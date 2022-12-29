package de.han.ekl.backend.api.user;

import de.han.ekl.backend.exception.UserNotFoundException;
import de.han.ekl.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(String id) throws UserNotFoundException {
        return userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Not found user with Id[%s]",id)));
    }
}
