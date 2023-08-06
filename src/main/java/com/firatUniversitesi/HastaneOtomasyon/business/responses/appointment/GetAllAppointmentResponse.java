package com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAppointmentResponse {
    private int id;
    private LocalDateTime appointmentTime;
    private String patientName;
    private String patientSurName;
}
