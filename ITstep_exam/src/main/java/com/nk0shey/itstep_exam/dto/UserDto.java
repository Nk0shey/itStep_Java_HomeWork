package com.nk0shey.itstep_exam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Ім'я не може бути порожнім")
    private String name;

    @NotBlank(message = "Email не може бути порожнім")
    @Email(message = "Email має бути валідним")
    private String email;
}
