package org.example.surveyapi.infraestructure.configurations.security.user;

import lombok.Data;

@Data
public class UserAuthDto {
    private String email;
    private String password;
}
