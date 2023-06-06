package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.ReportService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.report.CreateReportRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.report.GetByIdReportResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.ReportRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Report;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportManager implements ReportService {
    private ReportRepository reportRepository;
    private ModelMapperService modelMapperService;
    @Override
    public GetByIdReportResponse getById(int id) {
        Report report = this.reportRepository.findById(id).orElseThrow();
        GetByIdReportResponse response = this.modelMapperService.forResponse().map(report, GetByIdReportResponse.class);
        return response;
    }

    @Override
    public void add(CreateReportRequest createReportRequest) {

    }
}
