package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.report.CreateReportRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.report.GetByIPatientIdResponse;

import java.util.List;

public interface ReportService {
    GetByIPatientIdResponse getById(int id);
    List<GetByIPatientIdResponse> getByPatientId(int id);
    void add(CreateReportRequest createReportRequest);
    void delete(int id);
}
