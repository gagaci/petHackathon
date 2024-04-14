package com.company.pethackathon.registration;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String email;

    private final String password;
}
