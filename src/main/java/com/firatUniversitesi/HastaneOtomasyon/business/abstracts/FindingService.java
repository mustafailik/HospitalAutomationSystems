package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.finding.CreateFindingRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.finding.GetByIdFindingResponse;

public interface FindingService {
    GetByIdFindingResponse getById(int id);
    void add(CreateFindingRequest createFindingRequest);
}
