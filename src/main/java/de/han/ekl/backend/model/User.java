package de.han.ekl.backend.model;

import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private UUID id;

    private String firstname;

    private String lastname;

    private LocalDate birthday;

    private String email;

    private String passwd;

    @Transient private String token;
}
