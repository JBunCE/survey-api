package org.example.surveyapi.infraestructure.web.controllers;

import jakarta.validation.Valid;
import org.example.surveyapi.application.jwt.JwtService;
import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.responses.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("token")
public class JwtController {

    @Autowired
    private JwtService service;

    @PostMapping("user/refresh")
    public ResponseEntity<BaseResponse> refreshUser(@RequestBody @Valid JwtRequest request) {
        return service.userTokenRefresh(request.getRefreshToken()).apply();
    }
}

