package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.AppointmentService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.ApproveAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.appointment.CreateAppointmentRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetAllAppointmentResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByDoctorIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByIdAppointmentResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByPatientIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
public class AppointmentsController {

    AppointmentService appointmentService;

    @GetMapping("/getAll")
    public List<GetAllAppointmentResponse> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/getByPatientId")
    public List<GetByPatientIdResponse> getByPatientId(int patientId){
        return appointmentService.getByPatientId(patientId);
    }

    @GetMapping("/getByDoctorId")
    public List<GetByDoctorIdResponse> getByDoctorId(int doctorId){
        return appointmentService.getByDoctorId(doctorId);
    }

    @GetMapping("/{id}")
    public GetByIdAppointmentResponse getById(@PathVariable int id){
        return appointmentService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAppointmentRequest createAppointmentRequest){
        this.appointmentService.add(createAppointmentRequest);
    }

    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void approve(@RequestBody ApproveAppointmentRequest approveAppointmentRequest){
        this.appointmentService.approve(approveAppointmentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.appointmentService.delete(id);
    }

    @PutMapping("/{id}")
    public void cancel(@PathVariable int id){

        this.appointmentService.cancel(id);
    }
}
