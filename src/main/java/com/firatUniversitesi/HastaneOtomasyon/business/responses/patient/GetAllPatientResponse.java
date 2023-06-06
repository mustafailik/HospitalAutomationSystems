package com.firatUniversitesi.HastaneOtomasyon.business.responses.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPatientResponse {
    private int id;
    private String name;
    private String surName;
    private String identityNumber;
}
