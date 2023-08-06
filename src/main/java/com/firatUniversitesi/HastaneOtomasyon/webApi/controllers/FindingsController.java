package com.firatUniversitesi.HastaneOtomasyon.webApi.controllers;

import com.firatUniversitesi.HastaneOtomasyon.business.abstracts.FindingService;
import com.firatUniversitesi.HastaneOtomasyon.business.requests.finding.CreateFindingRequest;
import com.firatUniversitesi.HastaneOtomasyon.business.responses.finding.GetByIdFindingResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/findings")
@AllArgsConstructor
public class FindingsController {
    private FindingService findingService;


    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateFindingRequest createFindingRequest){
        this.findingService.add(createFindingRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.findingService.delete(id);
    }

}
