package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.polyclinic.CreatePolyclinicRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.polyclinic.GetAllPolyclinicResponse;

import java.util.List;

public interface PolyclinicService {
    List<GetAllPolyclinicResponse> getAll();
    void add(CreatePolyclinicRequest createPolyclinicRequest);
    void delete(int id);

}
