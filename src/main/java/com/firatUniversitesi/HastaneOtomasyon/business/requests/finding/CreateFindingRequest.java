package com.firatUniversitesi.HastaneOtomasyon.business.requests.finding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFindingRequest {
    @NotNull
    @NotBlank
    private String content;
    @NotBlank
    @NotNull
    private int patientId;
}
