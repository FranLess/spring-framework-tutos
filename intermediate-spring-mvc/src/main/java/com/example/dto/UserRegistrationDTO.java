package com.example.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Validated
public class UserRegistrationDTO {

    @Getter
    @Setter
    @NotBlank
    private String name;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private char[] password;
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String[] hobbies;
    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    @Valid
    private ContactInfoDTO contact;
}
