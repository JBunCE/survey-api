package org.example.surveyapi.web.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
    private Long userId;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private Integer phoneNumber;
}
