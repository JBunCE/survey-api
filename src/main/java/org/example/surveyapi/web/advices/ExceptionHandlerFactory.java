package org.example.surveyapi.web.advices;

import org.example.surveyapi.web.dtos.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerFactory {

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<BaseResponse> handleRuntimeException(RuntimeException e){
        return BaseResponse.builder()
                .message(e.getLocalizedMessage())
                .success(Boolean.FALSE)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .statusCode(500).build().apply();
    }

}
