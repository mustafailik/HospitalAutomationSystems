package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.ReportService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.report.CreateReportRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.report.GetByIdReportResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportsController {
    private ReportService reportService;

    @GetMapping("/{id}")
    public GetByIdReportResponse getById(@PathVariable int id){
        return reportService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateReportRequest createReportRequest){
        this.reportService.add(createReportRequest);
    }

}
