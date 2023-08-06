package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.AppointmentService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.ApproveAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.CreateAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetAllAppointmentResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByDoctorIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByIdAppointmentResponse;

import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByPatientIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.*;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AppointmentManager implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    private PatientRepository  patientRepository;
    private ModelMapperService modelMapperService;
    private final DoctorRepository doctorRepository;

    private final ReportRepository reportRepository;

    private final PrescriptionRepository prescriptionRepository;

    @Override
    public List<GetAllAppointmentResponse> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<GetAllAppointmentResponse> appointmentsResponse = appointments.stream()
                .map(appointment -> this.modelMapperService.forResponse()
                        .map(appointment, GetAllAppointmentResponse.class)).collect(Collectors.toList());
        return appointmentsResponse;
    }

    @Override
    public List<GetByPatientIdResponse> getByPatientId(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        List<Appointment> appointments = appointmentRepository.findByPatient(patient);
        List<GetByPatientIdResponse> appointmentsResponse = appointments.stream()
                .map(appointment -> this.modelMapperService.forResponse()
                        .map(appointment, GetByPatientIdResponse.class)).collect(Collectors.toList());
        return appointmentsResponse;
    }

    @Override
    public List<GetByDoctorIdResponse> getByDoctorId(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        List<Appointment> appointments = appointmentRepository.findByDoctor(doctor);
        List<GetByDoctorIdResponse> appointmentsResponse = appointments.stream()
                .map(appointment -> this.modelMapperService.forResponse()
                        .map(appointment, GetByDoctorIdResponse.class)).collect(Collectors.toList());
        return appointmentsResponse;
    }

    @Override
    public GetByIdAppointmentResponse getById(int id) {
        Appointment appointment = this.appointmentRepository.findById(id).orElseThrow();
        GetByIdAppointmentResponse response = this.modelMapperService.forResponse().map(appointment, GetByIdAppointmentResponse.class);
        return response;
    }

    @Override
    public void add(CreateAppointmentRequest createAppointmentRequest) {
        createAppointmentRequest.setStatus("Muayene Bekliyor");
        Appointment appointment = this.modelMapperService.forRequest().map(createAppointmentRequest, Appointment.class);
        this.appointmentRepository.save(appointment);
    }

    @Override
    public void approve(ApproveAppointmentRequest approveAppointmentRequest) {
        Appointment appointment = this.appointmentRepository.findById(approveAppointmentRequest.getAppointmentId()).orElseThrow();
        appointment.setStatus("Tamamlandı");
        Report report = new Report();
        report.setContent(approveAppointmentRequest.getReportContent());
        report.setAppointment(appointment);
        report.setReportTime(LocalDateTime.now());
        report.setPatient(appointment.getPatient());
        this.reportRepository.save(report);

        Prescription prescription = new Prescription();
        prescription.setContent(approveAppointmentRequest.getPrescriptionContent());
        prescription.setAppointment(appointment);
        prescription.setPrescriptionTime(LocalDateTime.now());
        prescription.setPatient(appointment.getPatient());
        this.prescriptionRepository.save(prescription);

        this.appointmentRepository.save(appointment);

    }

    @Override
    public void delete(int id) {
        this.appointmentRepository.deleteById(id);
    }

    @Override
    public void cancel(int id) {
        Appointment appointment = this.appointmentRepository.findById(id).orElseThrow();
        appointment.setStatus("İptal");
        this.appointmentRepository.save(appointment);
    }
}
