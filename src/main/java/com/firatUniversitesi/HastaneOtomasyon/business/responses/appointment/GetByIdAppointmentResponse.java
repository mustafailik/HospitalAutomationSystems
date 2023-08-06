package com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAppointmentResponse {
    private int id;
    private LocalDateTime appointmentTime;
    private String patientName;
    private String patientSurName;
}
