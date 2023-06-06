package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.DoctorService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.CreateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.UpdateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetAllDoctorResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetByIdDoctorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
public class DoctorsController {
    private DoctorService doctorService;
    @GetMapping("/getAll")
    public List<GetAllDoctorResponse> getAll(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdDoctorResponse getById(@PathVariable int id){
        return getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateDoctorRequest createDoctorRequest){
        this.doctorService.add(createDoctorRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateDoctorRequest updateDoctorRequest){
        this.doctorService.update(updateDoctorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.doctorService.delete(id);
    }
}
