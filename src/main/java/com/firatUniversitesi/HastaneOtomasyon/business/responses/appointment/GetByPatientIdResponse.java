package com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByPatientIdResponse {

    private LocalDateTime appointmentTime;

    private int appointmentId;

    private String status;

    private String polyclinicName;

    private String patientSurName;

    private String doctorName;

    private String doctorSurName;

    private String patientName;

}
