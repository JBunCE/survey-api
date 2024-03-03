package org.example.surveyapi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
    private String userId;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private Integer phoneNumber;
}
