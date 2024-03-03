package org.example.surveyapi.domain.models.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtRequest {

    @NotBlank
    private String refreshToken;

}
