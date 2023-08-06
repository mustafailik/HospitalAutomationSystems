package com.firatUniversitesi.HastaneOtomasyon.dataAccess.abstracts;

import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Patient;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Prescription;
import com.firatUniversitesi.HastaneOtomasyon.entities.concretes.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByPatient(Patient patient);
}
