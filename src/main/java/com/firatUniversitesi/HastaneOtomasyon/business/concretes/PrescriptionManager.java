package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PrescriptionService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.prescription.CreatePrescriptionRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.appointment.GetByDoctorIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIPatientIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.prescription.GetByIdPrescriptionResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PatientRepository;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PrescriptionRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Prescription;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PrescriptionManager implements PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    private PatientRepository patientRepository;
    private ModelMapperService modelMapperService;


    @Override
    public GetByIdPrescriptionResponse getById(int id) {
        Prescription prescription = this.prescriptionRepository.findById(id).orElseThrow();
        GetByIdPrescriptionResponse response = this.modelMapperService.forResponse().map(prescription, GetByIdPrescriptionResponse.class);
        return response;
    }

    @Override
    public List<GetByIPatientIdResponse> getByPatientId(int id) {
        Patient patient  =  this.patientRepository.findById(id).orElseThrow();
        List<Prescription> prescriptionList = this.prescriptionRepository.findByPatient(patient);
        List<GetByIPatientIdResponse> prescriptionsResponse = prescriptionList.stream()
                .map(prescription -> this.modelMapperService.forResponse()
                        .map(prescription, GetByIPatientIdResponse.class)).collect(Collectors.toList());

        return prescriptionsResponse;
    }

    @Override
    public void add(CreatePrescriptionRequest createPrescriptionRequest) {
    Prescription prescription = this.modelMapperService.forRequest().map(createPrescriptionRequest, Prescription.class);
    this.prescriptionRepository.save(prescription);
    }

    @Override
    public void delete(int id) {
        this.prescriptionRepository.deleteById(id);
    }
}
