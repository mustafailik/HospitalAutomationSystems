package com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorRequest {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String surName;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String userName;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String password;
    @NotNull
    @NotBlank
    private int polyclinicId;

}
