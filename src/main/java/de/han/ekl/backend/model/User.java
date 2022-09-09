package de.han.ekl.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private Boolean isLogin;
}
