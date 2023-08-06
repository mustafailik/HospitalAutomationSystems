package com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApproveAppointmentRequest {

    private String prescriptionContent;
    private String reportContent;
    private int appointmentId;

}
