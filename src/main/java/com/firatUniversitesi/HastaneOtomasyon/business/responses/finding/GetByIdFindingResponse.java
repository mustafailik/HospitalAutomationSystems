package com.firatUniversitesi.HastaneOtomasyon.business.responses.finding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFindingResponse {
    private int id;
    private String content;
    private String patientName;
    private String patientSurName;
}
