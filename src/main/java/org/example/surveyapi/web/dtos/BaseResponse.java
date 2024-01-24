package org.example.surveyapi.web.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter @Setter @Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseResponse {
    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus status;
    private Integer statusCode;

    public ResponseEntity<BaseResponse> apply(){
        return new ResponseEntity<>(this, status);
    }

}
