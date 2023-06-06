package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription.CreatePrescriptionRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIdPrescriptionResponse;



public interface PrescriptionService {
    GetByIdPrescriptionResponse getById(int id);
    void add(CreatePrescriptionRequest createPrescriptionRequest);
}
