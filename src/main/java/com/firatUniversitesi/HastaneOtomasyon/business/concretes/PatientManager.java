package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PatientService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.patient.CreatePatientRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.patient.GetAllPatientResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PatientRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientManager implements PatientService {
    private PatientRepository patientRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllPatientResponse> getAll() {
        List<Patient> patients = patientRepository.findAll();
        List<GetAllPatientResponse> patientsResponse = patients.stream()
                .map(patient -> this.modelMapperService.forResponse()
                        .map(patient, GetAllPatientResponse.class)).collect(Collectors.toList());
        return patientsResponse;
    }

    @Override
    public void add(CreatePatientRequest createPatientRequest) {
        Patient patient = this.modelMapperService.forRequest().map(createPatientRequest, Patient.class);
        this.patientRepository.save(patient);
    }
}
