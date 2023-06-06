package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.DoctorService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.CreateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.doctor.UpdateDoctorRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetAllDoctorResponse;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.doctor.GetByIdDoctorResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.DoctorRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorManager implements DoctorService {
    private DoctorRepository doctorRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllDoctorResponse> getAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<GetAllDoctorResponse> doctorsResponse = doctors.stream()
                .map(doctor -> this.modelMapperService.forResponse()
                        .map(doctor, GetAllDoctorResponse.class)).collect(Collectors.toList());
        return doctorsResponse;
    }

    @Override
    public GetByIdDoctorResponse getById(int id) {
        Doctor doctor = this.doctorRepository.findById(id).orElseThrow();
        GetByIdDoctorResponse response = this.modelMapperService.forResponse().map(doctor, GetByIdDoctorResponse.class);
        return response;
    }

    @Override
    public void add(CreateDoctorRequest createDoctorRequest) {
        Doctor doctor = this.modelMapperService.forRequest().map(createDoctorRequest, Doctor.class);
        this.doctorRepository.save(doctor);
    }

    @Override
    public void update(UpdateDoctorRequest updateDoctorRequest) {
        Doctor doctor = this.modelMapperService.forRequest().map(updateDoctorRequest, Doctor.class);
        this.doctorRepository.save(doctor);
    }

    @Override
    public void delete(int id) {
        this.doctorRepository.deleteById(id);
    }
}
