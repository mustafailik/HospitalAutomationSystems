package com.firatUniversitesi.HastaneOtomasyon.business.requests.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String surName;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String identityNumber;
}
