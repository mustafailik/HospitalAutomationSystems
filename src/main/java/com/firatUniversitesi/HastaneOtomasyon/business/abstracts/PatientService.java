package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.patient.CreatePatientRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetAllPatientResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetByIdPatientResponse;

import java.util.List;

public interface PatientService {
    List<GetAllPatientResponse> getAll();

    GetByIdPatientResponse getById(int id);

    void add(CreatePatientRequest createPatientRequest);
    void delete(int id);

}
