package com.firatUniversitesi.HastaneOtomasyon.business.responses.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdPatientResponse {
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String identityNumber;
}
