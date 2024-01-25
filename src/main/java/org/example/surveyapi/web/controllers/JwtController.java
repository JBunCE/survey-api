package org.example.surveyapi.web.controllers;

import jakarta.validation.Valid;
import org.example.surveyapi.configurations.jwt.JwtService;
import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.JwtRequest;
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

