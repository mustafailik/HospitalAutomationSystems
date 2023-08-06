package com.firatUniversitesi.HastaneOtomasyon.business.concretes;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.ReportService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.report.CreateReportRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.report.GetByIPatientIdResponse;
import com.firatUniversitesi.HastaneOtomasyon.core.utilities.mappers.ModelMapperService;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.PatientRepository;
import com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts.ReportRepository;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Prescription;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Report;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportManager implements ReportService {
    private ReportRepository reportRepository;

    private PatientRepository patientRepository;
    private ModelMapperService modelMapperService;
    @Override
    public GetByIPatientIdResponse getById(int id) {
        Report report = this.reportRepository.findById(id).orElseThrow();
        GetByIPatientIdResponse response = this.modelMapperService.forResponse().map(report, GetByIPatientIdResponse.class);
        return response;
    }

    @Override
    public void add(CreateReportRequest createReportRequest) {

    }

    @Override
    public List<GetByIPatientIdResponse> getByPatientId(int id) {
        Patient patient  =  this.patientRepository.findById(id).orElseThrow();
        List<Report> reportList = this.reportRepository.findByPatient(patient);
        List<GetByIPatientIdResponse> reportsResponse = reportList.stream()
                .map(report -> this.modelMapperService.forResponse()
                        .map(report,GetByIPatientIdResponse.class)).collect(Collectors.toList());

        return reportsResponse;
    }

    @Override
    public void delete(int id) {
        this.reportRepository.deleteById(id);
    }
}
