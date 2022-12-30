package de.han.ekl.backend.exception;

public class UsernameOrPasswordInvalidException extends Exception{
    public UsernameOrPasswordInvalidException(String msg){
        super(msg);
    }
}
