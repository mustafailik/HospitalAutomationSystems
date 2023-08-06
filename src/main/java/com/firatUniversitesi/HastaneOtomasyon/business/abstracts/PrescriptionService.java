package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription.CreatePrescriptionRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIPatientIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIdPrescriptionResponse;

import java.util.List;


public interface PrescriptionService {
    GetByIdPrescriptionResponse getById(int id);

    List<GetByIPatientIdResponse> getByPatientId(int id);
    void add(CreatePrescriptionRequest createPrescriptionRequest);
    void delete(int id);
}
