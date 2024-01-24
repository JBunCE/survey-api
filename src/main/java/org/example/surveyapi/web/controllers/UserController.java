package org.example.surveyapi.web.controllers;

import jakarta.validation.Valid;
import org.example.surveyapi.service.IUserServices;
import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserServices services;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> getUser(@PathVariable Long id){
        return services.get(id).apply();
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequest request){
        return services.create(request).apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest request){
        return services.update(request, id).apply();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable Long id){
        return services.delete(id).apply();
    }

}
