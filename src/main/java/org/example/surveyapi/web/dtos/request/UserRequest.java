package org.example.surveyapi.web.dtos.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Email @NotBlank
    private String email;

    @NotNull
    private Long phoneNumber;

    @NotBlank @Size(min = 8)
    private String password;
}
