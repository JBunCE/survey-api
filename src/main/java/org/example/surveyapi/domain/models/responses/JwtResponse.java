package org.example.surveyapi.domain.models.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
}
