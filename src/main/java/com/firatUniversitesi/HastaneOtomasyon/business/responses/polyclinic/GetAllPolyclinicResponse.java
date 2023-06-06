package com.firatUniversitesi.HastaneOtomasyon.business.responses.polyclinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPolyclinicResponse {
    private int id;
    private String name;
}
