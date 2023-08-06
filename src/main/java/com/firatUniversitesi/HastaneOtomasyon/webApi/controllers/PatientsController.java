package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PatientService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.patient.CreatePatientRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetAllPatientResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetByIdPatientResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientsController {
private PatientService patientService;

    @GetMapping("/getAll")
    public List<GetAllPatientResponse> getAll(){
    return patientService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdPatientResponse getById(@PathVariable int id){
        return patientService.getById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatePatientRequest createPatientRequest){
        this.patientService.add(createPatientRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.patientService.delete(id);
    }

}
