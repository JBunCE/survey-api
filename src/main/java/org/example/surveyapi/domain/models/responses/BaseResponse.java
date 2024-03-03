package org.example.surveyapi.domain.models.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter @Setter @Builder
public class BaseResponse {

    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus status;
    private Integer statusCode;

    public ResponseEntity<BaseResponse> apply() {
        return new ResponseEntity<>(this, status);
    }

}
