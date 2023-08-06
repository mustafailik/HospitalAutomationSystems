package com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorResponse {

    private int id;
    private String name;
    private String surName;
}
