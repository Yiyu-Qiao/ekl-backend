package de.han.ekl.backend.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg){
        super(msg);
    }
}
