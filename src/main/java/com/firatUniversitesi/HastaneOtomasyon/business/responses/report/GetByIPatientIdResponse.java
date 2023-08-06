package com.firatUniversitesi.HastaneOtomasyon.business.responses.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIPatientIdResponse {
    private int id;
    private String content;
    private LocalDateTime prescriptionTime;
    private String patientName;
    private String patientSurName;
    private String polyclinicName;
}
