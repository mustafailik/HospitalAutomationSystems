package com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorRequest {
    private int id;
    private String name;
    private String surName;
}
