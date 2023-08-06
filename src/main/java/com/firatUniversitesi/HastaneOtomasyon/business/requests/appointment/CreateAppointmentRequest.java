package com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequest {

    @NotNull
    @NotBlank
    private LocalDateTime appointmentTime;
    @NotNull
    @NotBlank
    private int patientId;

    @NotNull
    @NotBlank
    private int doctorId;

    private String status;

}
