package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String crushName;
    @Getter
    @Setter
    @NotBlank
    String email;
}
