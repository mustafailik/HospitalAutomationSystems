package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.ApproveAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.CreateAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetAllAppointmentResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByDoctorIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByIdAppointmentResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByPatientIdResponse;

import java.util.List;

public interface AppointmentService {
    List<GetAllAppointmentResponse> getAll();

    List<GetByPatientIdResponse> getByPatientId(int patientId);

    List<GetByDoctorIdResponse> getByDoctorId(int doctorId);

    GetByIdAppointmentResponse getById(int id);

    void add(CreateAppointmentRequest createAppointmentRequest);

    void approve(ApproveAppointmentRequest approveAppointmentRequest);

    void delete(int id);

    void cancel(int id);
}
