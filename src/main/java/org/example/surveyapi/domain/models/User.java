package org.example.surveyapi.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.surveyapi.domain.models.value.objects.Contact;

@Getter @Setter
public class User {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank @Size(min = 8)
    private String password;

    @NotBlank
    private Contact contact;

}
