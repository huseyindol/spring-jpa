package com.jpatutorial.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "FirstName alanı boş bırakılamaz!")
    @Min(value = 3, message = "En az 3 karakter gir")
    @Max(value = 10, message = "En fazla 10 karakter gir.")
    private String firstName;

    @Size(min = 3, max = 30, message = "3 ve 10 karakter arası gir.")
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Email Formatında giriniz!")
    @NotEmpty(message = "email alanı boş olamaz!")
    private String email;

    @Size(min = 11, max = 11, message = "Tckn alanı 11 karakter olmalıdır.")
    @NotEmpty(message = "Tckn alanı boş geçilemez!")
    private String tckn;
}
