package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PrescriptionService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription.CreatePrescriptionRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIdPrescriptionResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PrescriptionRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Prescription;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PrescriptionManager implements PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    private ModelMapperService modelMapperService;


    @Override
    public GetByIdPrescriptionResponse getById(int id) {
        Prescription prescription = this.prescriptionRepository.findById(id).orElseThrow();
        GetByIdPrescriptionResponse response = this.modelMapperService.forResponse().map(prescription, GetByIdPrescriptionResponse.class);
        return response;
    }

    @Override
    public void add(CreatePrescriptionRequest createPrescriptionRequest) {
    Prescription prescription = this.modelMapperService.forRequest().map(createPrescriptionRequest, Prescription.class);
    this.prescriptionRepository.save(prescription);
    }
}
