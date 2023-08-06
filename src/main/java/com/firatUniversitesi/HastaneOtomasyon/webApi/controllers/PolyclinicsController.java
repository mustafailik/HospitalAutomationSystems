package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PolyclinicService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.patient.CreatePatientRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.polyclinic.CreatePolyclinicRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.polyclinic.GetAllPolyclinicResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polyclinics")
@AllArgsConstructor
public class PolyclinicsController {
    private PolyclinicService polyclinicService;
    @GetMapping("/getAll")
    private List<GetAllPolyclinicResponse> getAll(){
        return polyclinicService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatePolyclinicRequest createPolyclinicRequest){
        this.polyclinicService.add(createPolyclinicRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.polyclinicService.delete(id);
    }
}
