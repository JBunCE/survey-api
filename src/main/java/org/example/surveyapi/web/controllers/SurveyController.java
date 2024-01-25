package org.example.surveyapi.web.controllers;

import org.example.surveyapi.service.ISurveyService;
import org.example.surveyapi.web.dtos.BaseResponse;
import org.example.surveyapi.web.dtos.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("survey")
public class SurveyController {

    @Autowired
    private ISurveyService service;

    @GetMapping("{id}")
    private ResponseEntity<BaseResponse> getSurvey(@PathVariable Long id) {
        return service.get(id).apply();
    }

    @PostMapping
    private ResponseEntity<BaseResponse> create(@RequestBody SurveyRequest request) {
        return service.create(request).apply();
    }

    @PutMapping("{id}")
    private ResponseEntity<BaseResponse> update(@RequestBody SurveyRequest request, @PathVariable Long id) {
        return service.update(request, id).apply();
    }

    @DeleteMapping("{id}")
    private ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        return service.delete(id).apply();
    }

}
