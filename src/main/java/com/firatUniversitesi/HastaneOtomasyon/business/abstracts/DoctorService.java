package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.CreateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.UpdateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetAllDoctorResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetByIdDoctorResponse;

import java.util.List;

public interface DoctorService {
    List<GetAllDoctorResponse> getAll();
    GetByIdDoctorResponse getById(int id);
    void add(CreateDoctorRequest createDoctorRequest);
    void update(UpdateDoctorRequest updateDoctorRequest);
    void delete(int id);


}
