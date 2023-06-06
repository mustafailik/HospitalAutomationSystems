package com.firatUniversitesi.HastaneOtomasyon.business.responses.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdReportResponse {
    private int id;
    private String content;
    private LocalDateTime reportTime;
    private String patientName;
    private String patientSurName;
}
