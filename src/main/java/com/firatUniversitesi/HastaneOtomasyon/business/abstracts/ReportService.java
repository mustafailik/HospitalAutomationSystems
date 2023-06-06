package com.firatUniversitesi.HastaneOtomasyon.business.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.business.requests.report.CreateReportRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.report.GetByIdReportResponse;

import java.util.List;

public interface ReportService {
    GetByIdReportResponse getById(int id);
    void add(CreateReportRequest createReportRequest);
}
