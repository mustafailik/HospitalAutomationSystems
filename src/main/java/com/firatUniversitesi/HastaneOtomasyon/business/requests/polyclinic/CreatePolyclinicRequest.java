package com.firatUniversitesi.HastaneOtomasyon.business.requests.polyclinic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePolyclinicRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
