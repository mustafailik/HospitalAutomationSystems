package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.patient.CreatePatientRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetAllPatientResponse;

import java.util.List;

public interface PatientService {
    List<GetAllPatientResponse> getAll();
    void add(CreatePatientRequest createPatientRequest);

}
