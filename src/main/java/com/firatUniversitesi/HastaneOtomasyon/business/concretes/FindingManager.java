package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.FindingService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.finding.CreateFindingRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.finding.GetByIdFindingResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.FindingRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Finding;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FindingManager implements FindingService {
    private FindingRepository findingRepository;
    private ModelMapperService modelMapperService;


    @Override
    public GetByIdFindingResponse getById(int id) {
        Finding finding = this.findingRepository.findById(id).orElseThrow();
        GetByIdFindingResponse response = this.modelMapperService.forResponse().map(finding, GetByIdFindingResponse.class);
        return  response;
    }

    @Override
    public void add(CreateFindingRequest createFindingRequest) {
        Finding finding = this.modelMapperService.forRequest().map(createFindingRequest, Finding.class);
        this.findingRepository.save(finding);
    }

    @Override
    public void delete(int id) {
        this.findingRepository.deleteById(id);
    }
}
