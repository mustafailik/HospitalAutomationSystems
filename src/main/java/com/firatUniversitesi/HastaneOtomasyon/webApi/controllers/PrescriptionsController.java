package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PrescriptionService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription.CreatePrescriptionRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIPatientIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIdPrescriptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@AllArgsConstructor
public class PrescriptionsController {
    private PrescriptionService prescriptionService;

    @GetMapping("/{id}")
    public GetByIdPrescriptionResponse getById(@PathVariable int id){
        return prescriptionService.getById(id);
    }


    @GetMapping("/")
    public List<GetByIPatientIdResponse> getByPatientId(@RequestParam int patientId){
        return prescriptionService.getByPatientId(patientId);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatePrescriptionRequest createPrescriptionRequest){
        this.prescriptionService.add(createPrescriptionRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.prescriptionService.delete(id);
    }
}
