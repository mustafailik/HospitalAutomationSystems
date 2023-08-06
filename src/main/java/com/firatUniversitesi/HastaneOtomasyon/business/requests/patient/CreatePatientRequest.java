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
    @Size(min = 2, max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String identityNumber;
}
