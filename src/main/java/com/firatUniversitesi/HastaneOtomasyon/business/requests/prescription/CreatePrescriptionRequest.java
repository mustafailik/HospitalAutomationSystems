package com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePrescriptionRequest {
    @NotNull
    @NotBlank
    private String content;
    @NotNull
    @NotBlank
    private LocalDateTime prescriptionTime;
    @NotBlank
    @NotNull
    private int patientId;

}
