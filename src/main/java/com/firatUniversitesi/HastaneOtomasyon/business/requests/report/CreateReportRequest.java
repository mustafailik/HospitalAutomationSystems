package com.firatUniversitesi.HastaneOtomasyon.business.requests.report;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportRequest {
    @NotNull
    @NotBlank
    private String content;
    @NotNull
    @NotBlank
    private LocalDateTime reportTime;
    @NotBlank
    @NotNull
    private int patientId;

}
