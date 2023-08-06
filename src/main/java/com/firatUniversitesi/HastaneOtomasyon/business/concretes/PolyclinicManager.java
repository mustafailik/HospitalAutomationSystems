package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.PolyclinicService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.polyclinic.CreatePolyclinicRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.polyclinic.GetAllPolyclinicResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PolyclinicRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Polyclinic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PolyclinicManager implements PolyclinicService {
    private PolyclinicRepository polyclinicRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllPolyclinicResponse> getAll() {
        List<Polyclinic> polyclinics = polyclinicRepository.findAll();
        List<GetAllPolyclinicResponse> polyclinicsResponse = polyclinics.stream()
                .map(polyclinic -> this.modelMapperService.forResponse()
                        .map(polyclinic, GetAllPolyclinicResponse.class)).collect(Collectors.toList());
        return polyclinicsResponse;
    }

    @Override
    public void add(CreatePolyclinicRequest createPolyclinicRequest) {
        Polyclinic polyclinic = this.modelMapperService.forRequest().map(createPolyclinicRequest, Polyclinic.class);
        this.polyclinicRepository.save(polyclinic);
    }

    @Override
    public void delete(int id) {
        this.polyclinicRepository.deleteById(id);
    }
}
