package com.example.dto;

import org.springframework.validation.annotation.Validated;

import com.example.jakartavalidator.ValidPhone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ContactInfoDTO {
    @Getter
    @Setter
    @NotBlank
    private String email;
    @Getter
    @Setter
    @ValidPhone
    private Phone phone;
}
